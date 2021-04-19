package com.example.reactdnd

import slinky.core.ExternalComponent
import slinky.core.annotations.react

import scala.scalajs.js

@react object DndProvider extends ExternalComponent {
  case class Props(
      backend: js.Object
  )
  override val component = ReactDndDom.DndProvider
}
