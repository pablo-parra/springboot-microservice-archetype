# springboot-microservice-archetype
Maven archetype to create backend projects based on Spring Boot and with Kubernetes configuration

## USAGE

1. Install the archetype in your local Maven repo (from project root): 
	```
	mvn clean install
	```
2. Create the project using the archetype with command:
	```
	mvn archetype:generate -DarchetypeGroupId=com.tastik -DarchetypeArtifactId=ms-archetype -DgroupId=[your groupId here] -DartifactId=[your artifactId here] -Dversion=[your version here, if not provided default will be 1.0.0-SNAPSHOT]
	```
	Once the command is launched it will ask also for 
	
	* _appName_ : the name to create class names such as main class, entities, etc.)
	* _k8s-namespace_ : the name of the Kubernetes namespace where the microservice will be deployed 
	
	```
	Define value for property 'appName' (should match expression '(^[A-Z])[a-z-A-Z]*$'): 
	Define value for property 'k8s-namespace': 
	```