package com.ivc.libraryweb.integration.config;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.sql.DataSource;
import org.dbunit.IDatabaseTester;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class RepositoryTestExecutionListener implements TestExecutionListener {

    private IDatabaseTester databaseTester;
    private static final String CLEAN_FILE = "clean_db.sql";

    @Override
    public void afterTestClass(TestContext arg0) throws Exception {
    }

    @Override
    public void afterTestMethod(TestContext arg0) throws Exception {
    }

    @Override
    public void beforeTestClass(TestContext arg0) throws Exception {
    }

    @Override
    public void beforeTestMethod(TestContext testCtx) throws Exception {
        DataSets dataSetAnnotation = testCtx.getTestMethod().getAnnotation(DataSets.class);
        if (dataSetAnnotation == null) {
            return;
        }

        String dataSetName = dataSetAnnotation.setUpDataSet();
        if (!dataSetName.equals("")) {
            ClassLoader classLoader = getClass().getClassLoader();
            Connection connection = ((DataSource) testCtx.getApplicationContext().getBean(DataSource.class)).getConnection();
            List<String> sqlLines = Files.readAllLines(Paths.get(classLoader.getResource(CLEAN_FILE).toURI()), StandardCharsets.UTF_8);
            sqlLines.addAll(Files.readAllLines(Paths.get(classLoader.getResource(dataSetName).toURI()), StandardCharsets.UTF_8));
            String query = "";
            for (String s : sqlLines) {
                query += s;
            }
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
            connection.close();
//            File file = new  File(classLoader.getResource(dataSetName).getFile());
//            databaseTester = (IDatabaseTester) testCtx.getApplicationContext().getBean("databaseTester");
//            IDataSet dataSet = new FlatXmlDataSet(file);
//            databaseTester.setDataSet(dataSet);
//            databaseTester.onSetup();
        }
    }

    @Override
    public void prepareTestInstance(TestContext arg0) throws Exception {
    }
}
