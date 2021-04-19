package com.example

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._

@react object DragAndDrop {
  type Props = Unit

  val component: FunctionalComponent[Props] = FunctionalComponent { _ =>
    div(
      h2("DragAndDrop")
    )
  }
}
