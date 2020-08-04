package org.movietime.webapp

import io.undertow.Handlers
import io.undertow.Undertow
import io.undertow.server.handlers.PathHandler
import io.undertow.servlet.Servlets
import io.undertow.servlet.api.DeploymentInfo
import io.undertow.servlet.api.ServletContainerInitializerInfo
import org.jboss.resteasy.plugins.servlet.ResteasyServletInitializer
import org.jboss.weld.environment.servlet.Listener

fun deploymentInfo( appRoot: Set<Class<*>>): DeploymentInfo {
    return Servlets.deployment()
        .addInitParameter("resteasy.injector.factory",
            "org.jboss.resteasy.cdi.CdiInjectorFactory")
        .addInitParameter("org.jboss.weld.environment.servlet.archive.isolation",
            "false")
        .addListener(Servlets.listener(Listener::class.java))
        .setClassLoader(MovieApp::class.java.classLoader)
        .setContextPath("/")
        .setDeploymentName("test.war")
        .addServletContainerInitializer(ServletContainerInitializerInfo(
            ResteasyServletInitializer::class.java, appRoot))
}

fun serverBuilder(port: Int, host: String, path :PathHandler): Undertow {
    return Undertow.builder().addHttpListener(port, host)
        .setHandler(path).build()
}

fun main() {

    val appRoot = setOf(MovieApp::class.java)

    val manager = Servlets.defaultContainer().addDeployment(deploymentInfo(appRoot))
    manager.deploy()

    val servletHandler = manager.start()
    val path = Handlers.path(Handlers.redirect("/"))
        .addPrefixPath("/", servletHandler)
    val server = serverBuilder(8080, "localhost", path)
    server.start()
}
