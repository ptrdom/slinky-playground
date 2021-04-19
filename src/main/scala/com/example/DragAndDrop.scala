package com.example

import com.example.reactdnd.DragSourceHookSpec
import com.example.reactdnd.DropTargetHookSpec
import com.example.reactdnd.Hooks.useDrag
import com.example.reactdnd.Hooks.useDrop
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html._
import org.scalajs.dom.window.alert

import scala.scalajs.js

@react object DragAndDrop {
  type Props = Unit

  val component: FunctionalComponent[Props] = FunctionalComponent { _ =>
    div(
      Draggable(),
      Droppable()
    )
  }
}

@react object Draggable {
  type Props = Unit

  val component: FunctionalComponent[Props] = FunctionalComponent { _ =>
    val (isDragging, drag, _) = useDrag(
      DragSourceHookSpec[DragObject, DropResult, Boolean]("draggableType")
        .setItem(new DragObject("draggable1"))
        .setEnd { (item, monitor) =>
          alert(
            s"You dropped ${item.name} into ${Option(monitor.getDropResult().asInstanceOf[DropResult]).map(_.name)}!"
          )
        }
        .setCollect(monitor => monitor.isDragging())
    )

    val opacity = if (isDragging) "0.4" else "1"

    div(
      ref := drag,
      style := js.Dynamic.literal(
        opacity = opacity,
        backgroundColor = "red",
        height = "150px",
        width = "150px",
        textAlign = "center"
      )
    )(
      "draggable1text"
    )
  }
}

@react object Droppable {
  type Props = Unit

  case class Collected(isOver: Boolean, canDrop: Boolean)

  val component: FunctionalComponent[Props] = FunctionalComponent { _ =>
    val (Collected(canDrop, isOver), drop) = useDrop(
      DropTargetHookSpec[DragObject, DropResult, Collected]("draggableType")
        .setDrop((dragObject, _) => new DropResult(s"droppableText received ${dragObject.name}"))
        .setCollect(monitor => Collected(monitor.isOver(), monitor.canDrop()))
    )

    val isActive = canDrop && isOver

    val backgroundColor: String =
      if (isActive) "darkgreen"
      else if (canDrop) "darkkhaki"
      else "green"

    div(
      ref := drop,
      style := js.Dynamic.literal(
        backgroundColor = backgroundColor,
        height = "150px",
        width = "150px",
        textAlign = "center"
      )
    )(
      "droppableText"
    )
  }
}

class DragObject(val name: String) extends js.Object
class DropResult(val name: String) extends js.Object
