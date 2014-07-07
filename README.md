WebSocket + Rest + Spring Example

	How to run it:
	Create eclipse project: mvn eclipse:eclipse -Dwtpversion=2.0 -DdownloadSources=true
	Import project in eclipse

Run Tomcat or Jetty

	Running with Tomcat
		Download Tomcat (apache-tomcat-7.0.54)

		Configure eclipse with Tomcat

		Run an application on Tomcat

	Running with Jetty
		mvn jetty:run


Open Chrome or Firefox browser

Run WebSocket client
	http://localhost:8080/notifications/index.jsp

	then click: Connect button

Send message via REST and notify via WebSocket (client part)

Run Spring REST

	http://localhost:8080/notifications/welcome


Run Jersey REST service:

	http://localhost:8080/notifications/rest/sample/save


