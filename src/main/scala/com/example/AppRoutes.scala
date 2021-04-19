package com.example

import com.example.Routes._
import com.example.reactdnd.DndProvider
import com.example.reactdnd.ReactDndHtml5Dom.HTML5Backend
import com.example.reactrouter.Link
import com.example.reactrouter.Route
import com.example.reactrouter.RouteProps
import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.div
import slinky.web.html.h1
import slinky.web.html.hr
import slinky.web.html.li
import slinky.web.html.ul

@react class AppRoutes extends Component {
  type Props = RouteProps

  case class State()

  override def componentDidMount(): Unit = {
    super.componentDidMount()
  }

  override def initialState: State = State()

  def render(): ReactElement = {
    div(
      h1(s"slinky-playground"),
      ul(
        li(Link(to = app)("App")),
        li(Link(to = dragAndDrop)("DragAndDrop")),
      ),
      hr(),
      Route.withComponent(exact = true, path = app, component = App),
      Route.withRender(exact = true, path = dragAndDrop, render = _ => DndProvider(HTML5Backend)(DragAndDrop()))
    )
  }
}

object Routes {
  val app         = "/"
  val dragAndDrop = "/drag-and-drop"
}
