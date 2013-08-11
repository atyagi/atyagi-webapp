package controllers

import play.api.mvc.{Controller, Action}

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.homepage.index())
  }

  def about = Action {
    Ok(views.html.about.about())
  }

  def contact = Action {
    Ok(views.html.contact.contact())
  }

  def blog = Action {
    Ok(views.html.blog.blogHome())
  }
  
}