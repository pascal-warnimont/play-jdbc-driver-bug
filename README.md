play-jdbc-driver-bug
====================

test code for Play issue  #1849

write a test using a fakeApplication for an Application.index() method simply calling DB.getDataSource().getConnection();

write DAO test using simple DriverManager.getConnection() for the same mysql db (for example using Spring JdbcTemplate )

both test execute successfully in eclipse, separate or together
both test execute sucesfully ONLY with test-only in Play console:
[play-jdbc-driver-bug] $ test-only ServiceTest
[info] Compiling 1 Java source to /Users/pascal/gittest/one-sanoma_backend/play-jdbc-driver-bug/target/scala-2.10/test-classes...
[info] ServiceTest
[info] + ServiceTest.test
[info] 
[info] 
[info] Total for test ServiceTest
[info] Finished in 0.0020 seconds
[info] 1 tests, 0 failures, 0 errors
[info] Passed: : Total 1, Failed 0, Errors 0, Passed 1, Skipped 0

if executed together, the simple jdbc acces fails with:

play-jdbc-driver-bug] $ test
[info] Compiling 1 Java source to /Users/pascal/gittest/one-sanoma_backend/play-jdbc-driver-bug/target/scala-2.10/classes...
[info] Test ApplicationTest.renderTemplate ignored
[info] ApplicationTest
[info] o ApplicationTest.renderTemplate
[info] + ApplicationTest.getUserInterestedInSegment
[info] 
[info] 
[info] Total for test ApplicationTest
[info] Finished in 0.0020 seconds
[info] 2 tests, 0 failures, 0 errors
[error] Test ServiceTest.test failed: No suitable driver found for jdbc:mysql://localhost:3306/segmenter?user=segmenter&password=segmenter
[error] at java.sql.DriverManager.getConnection(DriverManager.java:602)
[error] at java.sql.DriverManager.getConnection(DriverManager.java:207)
[error] at ServiceTest.test(ServiceTest.java:26)
[error] ...
[info] ServiceTest
[info] x ServiceTest.test
[info] 
[info] 
[info] Total for test ServiceTest
[info] Finished in 0.0 seconds
[info] 1 tests, 1 failures, 0 errors
[error] Failed: : Total 3, Failed 1, Errors 0, Passed 1, Skipped 1
[error] Failed tests:
[error] ServiceTest
error Tests unsuccessful
[error] Total time: 2 s, completed Oct 17, 2013 3:20:36 PM

This seem to depend on order of execution/compilation. Editing the Play test using fakeApplication, execute test, and the probleme disappears. But performing a clean command, then re executing a test command re triggres the issue. Log with reversed executoin order:

[play-jdbc-driver-bug] $ test
[info] Compiling 1 Java source to /Users/pascal/gittest/one-sanoma_backend/play-jdbc-driver-bug/target/scala-2.10/classes...
[info] Compiling 1 Java source to /Users/pascal/gittest/one-sanoma_backend/play-jdbc-driver-bug/target/scala-2.10/test-classes...
[info] ServiceTest
[info] + ServiceTest.test
[info] 
[info] 
[info] Total for test ServiceTest
[info] Finished in 0.0020 seconds
[info] 1 tests, 0 failures, 0 errors
[info] ApplicationTest
[info] + ApplicationTest.renderTemplate
[info] + ApplicationTest.getUserInterestedInSegment
[info] 
[info] 
[info] Total for test ApplicationTest
[info] Finished in 0.0 seconds
[info] 2 tests, 0 failures, 0 errors
[info] Passed: : Total 3, Failed 0, Errors 0, Passed 3, Skipped 0
[success] Total time: 2 s, completed Oct 17, 2013 3:21:14 PM
