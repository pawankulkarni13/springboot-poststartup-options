### How do you run custom code post SpringBoot is running

#### 1. Using CommandLineRunner interface
CommandLineRunner is a spring boot functional interface which is used to run code at application startup. It is present under package org.springframework.boot.

In startup process after the context is initialized, spring boot calls its run() method with command-line arguments provided to the application. 

To inform spring boot about our commandlineRunner interface, we can either implement it and add @Component annotation above the class or create its bean using @bean.

We can create multiple CommandLineRunners in one application. Using the Ordered interface or @Order annotation we can configure the order in which they should run. Lower value means higher the priority. By default all the components are created with lowest priority. 
That is why components without order configuration will be called last.

#### 2. With ApplicationRunner Interface

As discussed earlier, to access parsed arguments we need to use ApplicationRunner interface. 
ApplicationRunner interface provides run method with ApplicationArguments instead of raw string array.

ApplicationArguments is an interface which is available from srping boot 1.3 under the package org.springframework.boot.

Most important point to note that the Order is shared between CommandLineRunners and ApplicationRunners. 
That means the execution order could be mixed between commandlinerRunner and applicationRunner.

#### 3. Application event in Spring Boot

most important events in spring boot are,

- ApplicationContextInitializedEvent : triggered after ApplicationContext is prepared and 
ApplicationContextInitializers are called but before bean definitions are loaded
- ApplicationPreparedEvent : triggered after bean definitions are loaded
- ApplicationStartedEvent : triggered after context has been refreshed but before command-line and application runners are called
- ApplicationReadyEvent : triggered after any application and command-line runners are called
- ApplicationFailedEvent : triggered if there is an exception on startup

Multiple ApplicationListeners can be created. They can be ordered with the @Order annotation or Ordered interface.

The order is shared with other same type of ApplicationListeners but not with ApplicationRunners or CommandLineRunners.

#### 4. @Postconstruct annotation on a method
A method can be marked with @PostConstruct annotation. Whenever a method is marked with this annotation, it will be called immediately after the dependency injection.

A @PostConstruct method is linked to specific class hence it should be used for class specific code only. 
There can only be one method per class with postConstruct annotation.
Point to note is that if class is marked as lazy, that means the class is created when requested. 
After that the method marked with @postConstruct annotation will be executed.

The method marked with postConstruct annotation can have any name, however must not have any parameters. 
It must be void and should not be static.

#### 5. The InitializingBean Interface
The InitializingBean solution works exactly the similar to the postConstruct annotation. 
Instead of using annotation we have to implement an InitializingBean interface. 
Then we need to override void afterPropertiesSet() method.

InitializingBean is a part of org.springframework.beans.factory package.

what happens if we use both @PostConstruct annotation and InitializingBean together. 
Well in that case @PostConstruct method will be called before the InitializingBean's afterPropertiesSet() method.

#### 6. Init attribute of @bean annotation
We can provide a method using initMethod property in the @Bean annotation. 
This method will be called after bean is initialized.

The method provided in initMethod must be void and should not have any arguments. 
This method can even be private.

If we have InitializingBean implementation and initMethod property of @Bean annotation for the same class, 
then afterPropertiesSet method of InitializingBean will be called before the initMethod.

### Combining different approaches:
Lastly, sometimes we may need to combine multiple options. 
Then they will execute in the following order,

* Constructor
* PostContruct method
* afterPropertiesSet method
* Bean init Method
* ApplicationStartedEvent
* ApplicationRunner Or CommandLineRunner depends on Order
* ApplicationReadyEvent

Other Points
- There are different ways to run code after spring boot application startup
- We can use CommandLineRunner or ApplicationRunner Interface
- Use ApplicationRunner interface to access parsed arguments  instead of raw string array
- Spring boot event executes code on application startup
- Method marked with @PostConstruct annotation executes after the object initialization
- afterPropertiesSet() method of InitializingBean Interfacecalled after the object initialization
- @Bean annotation has an attribute 'initMethod' to provide method which will be called after bean initialization

**Also enjoy the colour coded logs.**