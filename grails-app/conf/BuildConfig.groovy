grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

/*grails.project.fork = [
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]*/

grails.project.fork = false

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    inherits("global") {
        excludes 'grails-plugin-log4j', 'log4j'
    }
    log "info"
    checksums true
    legacyResolve false

    repositories {
        inherits true

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        mavenRepo "https://repo.grails.org/grails/core"
    }

    dependencies {
        test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
        compile "ch.qos.logback:logback-classic:1.2.6"
//        compile "org.grails.plugins:logback:0.3.1"
    }

    plugins {
        build ":tomcat:7.0.70" // or ":tomcat:8.0.22"

        compile ":scaffolding:2.1.2"
        compile ':cache:1.1.8'
        compile ":asset-pipeline:2.5.7"

        runtime ":hibernate4:4.3.10" // or ":hibernate:3.6.10.18"
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.1"
    }
}
