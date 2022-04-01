# TQS_2022
TQS lab repository

Num mec. 81377

Notes: for lab1, the first folder inside TQS_lab1 says lab1 but should say lab1_1 since its the first task from lab1



Guião 3
Answers to review questions:

a)
from test: whenValidId_thenEmployeeShouldBeFound
assertThat(found.getName()).isEqualTo(name);

from test: given3Employees_whengetAll_thenReturn3Records
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());


b)
When testing the component employeeService in the class EmployeeService_UnitTest, we create a mock of the repository in order to simulate the interaction that the service has with the repository

@Mock( lenient = true)
    private EmployeeRepository employeeRepository;
...
Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);
Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);

c)

Mock is used when we dont need any dependencies from Spring Boot containers. It is fast and favors the isolation of the tested component
If our test needs to rely on the Spring Boot container and we also want to mock one of the container beans, we should use MockBean. It is used mostly in integration tests where a particular bean, like an external service, needs to be mocked.

d)
So in a spring boot application, application.properties file is used to write the application-related property into that file. This file contains the different configuration which is required to run the application in a different environment, and each environment will have a different property defined by it. Inside the application properties file, we define every type of property like changing the port, database connectivity, connection to the eureka server, and many more. 

from: https://www.geeksforgeeks.org/spring-boot-application-properties/

In our case, the file contains databse settings so that tests can be executed.

e)

Strategy C - more focused on the controller. Mock the dependencies on the service in order to see if the controller does what it is supposed to. Much faster since it does not deploy the application as a whole

Strategy D - We are testing the application as a whole. A typical integration test with several components. Deployed in a simnplified environment (does not use external server). Slower than the previous one but faster than the next one.

Strategy E - Also loads the full application. Tests the API with an explicit http Client, creating realistic requests. Request and
response un/marshaling will be involved
