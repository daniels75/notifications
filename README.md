WebSocket + Rest + Spring Example

First time run with:
mvn clean install -Pinit

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


OK (WebAppConfig -> @ComponentScan(basePackages = { "org.daniels.examples.notification.controller" }) )
Spring REST
org.springframework.web.context.WebApplicationContext:/notifications/SpringServlet
Parent: org.springframework.web.context.WebApplicationContext:/notifications

Jersey REST
Root Context: org.springframework.web.context.WebApplicationContext:/notifications
Parent: null


NOK (WebAppConfig -> @ComponentScan(basePackages = { "org.daniels.examples.notification" }) )

Spring REST
org.springframework.web.context.WebApplicationContext:/notifications/SpringServlet
Parent: org.springframework.web.context.WebApplicationContext:/notifications

Jersey REST
Root Context: org.springframework.web.context.WebApplicationContext:/notifications
Parent: null



Notifications

How to use Notifications
Use any REST client (Advance Rest Client) and run it with: http://<host>:8080/notifications/notify
For example you can use a zone address: http://localhost:8080/notifications/notify

Method: POST

Headers:
Accept: application/json


Payload:
{
"content":"testme","url":"your.url.com"
}


Set "Content-Type" to:
application/json
