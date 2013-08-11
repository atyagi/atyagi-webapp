package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import play.api.libs.ws.WS

class IntegrationSpec extends Specification {
  
  "Application" should {

    "run in a server" in new WithServer() {
      await(WS.url("http://localhost:" + port).get()).status must equalTo(OK)
    }

    "work from within a browser" in new WithBrowser() {
      browser.goTo("/")
      browser.title() must equalTo("Ankit Tyagi - Home")
    }

    "allow navbar clicks to work" in new WithBrowser() {
      browser.goTo("/")
      browser.$("#brand-home").click()
      browser.title() must equalTo("Ankit Tyagi - Home")

      browser.$("#homepage").click()
      browser.title() must equalTo("Ankit Tyagi - Home")

      browser.$("#about").click()
      browser.title() must equalTo("Ankit Tyagi - About")

    }
  }
  
}