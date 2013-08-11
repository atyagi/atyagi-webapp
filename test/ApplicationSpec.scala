package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.Result

class ApplicationSpec extends Specification {

  def pageHasHtmlAndContainsTest(text: String, page: Result): Boolean = {
    status(page) must equalTo(OK)
    contentType(page) must beSome.which(_ == "text/html")
    contentAsString(page) must contain(text)
  }

  "Application" should {

    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/nonsense")) must beNone
      }
    }
    
    "render the index page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get

        pageHasHtmlAndContainsTest("Ankit Tyagi - Home", home)
      }
    }

    "render the about page" in {
      running(FakeApplication()) {
        val about = route(FakeRequest(GET, "/about")).get

        pageHasHtmlAndContainsTest("Ankit Tyagi - About", about)
      }
    }
  }
}