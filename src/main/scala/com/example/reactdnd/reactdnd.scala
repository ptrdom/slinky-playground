package com.example.reactdnd

import com.example.StObject
import com.example.reactdnd.ConnectorTypes.ConnectDragPreview
import com.example.reactdnd.ConnectorTypes.ConnectDragSource
import com.example.reactdnd.ConnectorTypes.ConnectDropTarget
import com.example.reactdnd.MonitorTypes.DragSourceMonitor
import com.example.reactdnd.MonitorTypes.DropTargetMonitor
import com.example.reactdnd.OptionTypes.DragPreviewOptions
import com.example.reactdnd.OptionTypes.DragSourceOptions
import com.example.reactdnd.Types._
import slinky.core.facade.ReactRef

import scala.scalajs.js
import scala.scalajs.js.|

object MonitorTypes {
  @js.native
  trait DragSourceMonitor[DragObject, DropResult] extends StObject {

    /**
     * Returns true if no drag operation is in progress, and the owner's canDrag() returns true or is not defined.
     */
    def canDrag(): Boolean = js.native

    /**
     *  Returns true if some drop target has handled the drop event, false otherwise. Even if a target did not return a drop result, didDrop() returns true.
     * Use it inside endDrag() to test whether any drop target has handled the drop. Returns false if called outside endDrag().
     */
    def didDrop(): Boolean = js.native

    /**
     * Returns the last recorded { x, y } client offset of the pointer while a drag operation is in progress. Returns null if no item is being dragged.
     */
    def getClientOffset(): XYCoord | Null = js.native

    /**
     * Returns the { x, y } difference between the last recorded client offset of the pointer and the client offset when the current drag operation has started.
     * Returns null if no item is being dragged.
     */
    def getDifferenceFromInitialOffset(): XYCoord | Null = js.native

    /**
     * Returns a plain object representing the last recorded drop result. The drop targets may optionally specify it by returning an object from their
     * drop() methods. When a chain of drop() is dispatched for the nested targets, bottom up, any parent that explicitly returns its own result from drop()
     * overrides the child drop result previously set by the child. Returns null if called outside endDrag().
     */
    def getDropResult[T](): T | Null = js.native

    /**
     * Returns the { x, y } client offset of the pointer at the time when the current drag operation has started. Returns null if no item is being dragged.
     */
    def getInitialClientOffset(): XYCoord | Null = js.native

    /**
     * Returns the { x, y } client offset of the drag source component's root DOM node at the time when the current drag operation has started.
     * Returns null if no item is being dragged.
     */
    def getInitialSourceClientOffset(): XYCoord | Null = js.native

    /**
     * Returns a plain object representing the currently dragged item. Every drag source must specify it by returning an object from its beginDrag() method.
     * Returns null if no item is being dragged.
     */
    def getItem[T](): T = js.native

    /**
     * Returns a string or a symbol identifying the type of the current dragged item. Returns null if no item is being dragged.
     */
    def getItemType(): Identifier | Null = js.native

    /**
     * Returns the projected { x, y } client offset of the drag source component's root DOM node, based on its position at the time when the current drag operation has
     * started, and the movement difference. Returns null if no item is being dragged.
     */
    def getSourceClientOffset(): XYCoord | Null = js.native

    /**
     * Returns the ids of the potential drop targets.
     */
    def getTargetIds(): js.Array[Identifier] = js.native

    /**
     *  Returns true if a drag operation is in progress, and either the owner initiated the drag, or its isDragging() is defined and returns true.
     */
    def isDragging(): Boolean = js.native
  }

  @js.native
  trait DropTargetMonitor[DragObject, DropResult] extends StObject {

    /**
     * Returns true if there is a drag operation in progress, and the owner's canDrop() returns true or is not defined.
     */
    def canDrop(): Boolean = js.native

    /**
     *  Returns true if some drop target has handled the drop event, false otherwise. Even if a target did not return a drop result,
     * didDrop() returns true. Use it inside drop() to test whether any nested drop target has already handled the drop. Returns false
     * if called outside drop().
     */
    def didDrop(): Boolean = js.native

    /**
     * Returns the last recorded { x, y } client offset of the pointer while a drag operation is in progress. Returns null if no item is being dragged.
     */
    def getClientOffset(): XYCoord | Null = js.native

    /**
     * Returns the { x, y } difference between the last recorded client offset of the pointer and the client offset when current the drag operation has
     * started. Returns null if no item is being dragged.
     */
    def getDifferenceFromInitialOffset(): XYCoord | Null = js.native

    /**
     * Returns a plain object representing the last recorded drop result. The drop targets may optionally specify it by returning an
     * object from their drop() methods. When a chain of drop() is dispatched for the nested targets, bottom up, any parent that explicitly
     * returns its own result from drop() overrides the drop result previously set by the child. Returns null if called outside drop().
     */
    def getDropResult[T](): T | Null = js.native

    /**
     * Returns the { x, y } client offset of the pointer at the time when the current drag operation has started. Returns null if no item
     * is being dragged.
     */
    def getInitialClientOffset(): XYCoord | Null = js.native

    /**
     * Returns the { x, y } client offset of the drag source component's root DOM node at the time when the current drag operation has started.
     * Returns null if no item is being dragged.
     */
    def getInitialSourceClientOffset(): XYCoord | Null = js.native

    /**
     * Returns a plain object representing the currently dragged item. Every drag source must specify it by returning an object from
     * its beginDrag() method. Returns null if no item is being dragged.
     */
    def getItem[T](): T = js.native

    /**
     * Returns a string or a symbol identifying the type of the current dragged item. Returns null if no item is being dragged.
     */
    def getItemType(): Identifier | Null = js.native

    /**
     * Returns the projected { x, y } client offset of the drag source component's root DOM node, based on its position at the time when the current
     * drag operation has started, and the movement difference. Returns null if no item is being dragged.
     */
    def getSourceClientOffset(): XYCoord | Null = js.native

    /**
     * Returns true if there is a drag operation in progress, and the pointer is currently hovering over the owner.
     * You may optionally pass { shallow: true } to strictly check whether only the owner is being hovered, as opposed
     * to a nested target.
     */
    def isOver(): Boolean             = js.native
    def isOver(options: `0`): Boolean = js.native
  }

  @js.native
  trait XYCoord extends StObject {

    var x: Double = js.native

    var y: Double = js.native
  }
  object XYCoord {

    @scala.inline
    def apply(x: Double, y: Double): XYCoord = {
      val __obj = js.Dynamic.literal(x = x.asInstanceOf[js.Any], y = y.asInstanceOf[js.Any])
      __obj.asInstanceOf[XYCoord]
    }

    @scala.inline
    implicit class XYCoordMutableBuilder[Self <: XYCoord](val x: Self) extends AnyVal {

      @scala.inline
      def setX(value: Double): Self = StObject.set(x, "x", value.asInstanceOf[js.Any])

      @scala.inline
      def setY(value: Double): Self = StObject.set(x, "y", value.asInstanceOf[js.Any])
    }
  }

  @js.native
  trait `0` extends StObject {

    var shallow: js.UndefOr[Boolean] = js.native
  }
  object `0` {

    @scala.inline
    def apply(): `0` = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[`0`]
    }

    @scala.inline
    implicit class `0MutableBuilder`[Self <: `0`](val x: Self) extends AnyVal {

      @scala.inline
      def setShallow(value: Boolean): Self = StObject.set(x, "shallow", value.asInstanceOf[js.Any])

      @scala.inline
      def setShallowUndefined: Self = StObject.set(x, "shallow", js.undefined)
    }
  }

}

object OptionTypes {
  trait DragPreviewOptions
  trait DragSourceOptions
}

object ConnectorTypes {
  type ConnectDragPreview = ReactRef[js.Any]
  type ConnectDragSource  = ReactRef[js.Any]
  type ConnectDropTarget  = ReactRef[js.Any]
}

object Types {
  type Identifier = String | js.Symbol
  type SourceType = Identifier
  type TargetType = Identifier | js.Array[Identifier]

  type DragObjectFactory[DragObject, DropResult] =
    js.Function1[DragSourceMonitor[DragObject, DropResult], DragObject | Null]
}

object Hooks {

  def useDrag[DragObject, DropResult, CollectedProps](
      spec: DragSourceHookSpec[DragObject, DropResult, CollectedProps]
  ): (CollectedProps, ConnectDragSource, ConnectDragPreview) = {
    val callback = ReactDndDom.useDrag
      .asInstanceOf[js.Function1[js.Any, js.Tuple3[CollectedProps, ConnectDragSource, ConnectDragPreview]]](
        spec.asInstanceOf[js.Any]
      )
    (callback._1, callback._2, callback._3)
  }

  def useDrop[DragObject, DropResult, CollectedProps](
      spec: DropTargetHookSpec[DragObject, DropResult, CollectedProps]
  ): (CollectedProps, ConnectDropTarget) = {
    val callback = ReactDndDom.useDrop
      .asInstanceOf[js.Function1[js.Any, js.Tuple2[CollectedProps, ConnectDropTarget]]](
        spec.asInstanceOf[js.Any]
      )
    (callback._1, callback._2)
  }
}
@js.native
trait DragSourceHookSpec[DragObject, DropResult, CollectedProps] extends StObject {

  /**
   * Optional.
   * Use it to specify whether the dragging is currently allowed. If you want to always allow it, just omit this method.
   * Specifying it is handy if you'd like to disable dragging based on some predicate over props. Note: You may not call
   * monitor.canDrag() inside this method.
   */
  var canDrag: js.UndefOr[
    Boolean |(js.Function1[ /* monitor */ DragSourceMonitor[DragObject, DropResult], Boolean])
  ] = js.native

  /**
   * A function to collect rendering properties
   */
  var collect: js.UndefOr[
    js.Function1[ /* monitor */ DragSourceMonitor[DragObject, DropResult], CollectedProps]
  ] = js.native

  /**
   * Optional.
   * When the dragging stops, endDrag is called. For every beginDrag call, a corresponding endDrag call is guaranteed.
   * You may call monitor.didDrop() to check whether or not the drop was handled by a compatible drop target. If it was handled,
   * and the drop target specified a drop result by returning a plain object from its drop() method, it will be available as
   * monitor.getDropResult(). This method is a good place to fire a Flux action. Note: If the component is unmounted while dragging,
   * component parameter is set to be null.
   */
  var end: js.UndefOr[
    js.Function2[
      /* draggedItem */ DragObject,
      /* monitor */ DragSourceMonitor[DragObject, DropResult],
      Unit
    ]
  ] = js.native

  /**
   * Optional.
   * By default, only the drag source that initiated the drag operation is considered to be dragging. You can
   * override this behavior by defining a custom isDragging method. It might return something like props.id === monitor.getItem().id.
   * Do this if the original component may be unmounted during the dragging and later “resurrected” with a different parent.
   * For example, when moving a card across the lists in a Kanban board, you want it to retain the dragged appearance—even though
   * technically, the component gets unmounted and a different one gets mounted every time you move it to another list.
   *
   * Note: You may not call monitor.isDragging() inside this method.
   */
  var isDragging: js.UndefOr[js.Function1[ /* monitor */ DragSourceMonitor[DragObject, DropResult], Boolean]] =
    js.native

  /**
   * This property generates or defines a plain javascript item describing
   * the data being dragged. This is the only information available to the
   * drop targets about the drag source so it's important to pick the minimal
   * data they need to know.
   *
   * You may be tempted to put a reference to the component or complex object here,
   * but you should try very hard to avoid doing this because it couples the
   * drag sources and drop targets. It's a good idea to use something like
   * { id: props.id }
   *
   * If a function-form is used, it is invoked when the drag begins and returns a draggable item.
   * If the function returns null, the drag is canceled
   *
   */
  var item: js.UndefOr[DragObject | DragObjectFactory[DragObject, DropResult]] = js.native

  /**
   * The drag source options
   */
  var options: js.UndefOr[DragSourceOptions] = js.native

  /**
   * DragPreview options
   */
  var previewOptions: js.UndefOr[DragPreviewOptions] = js.native

  /**
   * The type of item being dragged. This is required when using the function form of spec.item.
   * If spec.item is a static object, the type may either be defined on that object as `item.type`, or it may
   * be defined here.
   */
  var `type`: SourceType = js.native
}

object DragSourceHookSpec {

  @scala.inline
  def apply[DragObject, DropResult, CollectedProps](
      `type`: SourceType
  ): DragSourceHookSpec[DragObject, DropResult, CollectedProps] = {
    val __obj = js.Dynamic.literal()
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[DragSourceHookSpec[DragObject, DropResult, CollectedProps]]
  }

  @scala.inline
  implicit class DragSourceHookSpecMutableBuilder[
      Self <: DragSourceHookSpec[_, _, _],
      DragObject,
      DropResult,
      CollectedProps
  ](val x: Self with (DragSourceHookSpec[DragObject, DropResult, CollectedProps]))
      extends AnyVal {

    @scala.inline
    def setCanDrag(
        value: Boolean |(js.Function1[ /* monitor */ DragSourceMonitor[DragObject, DropResult], Boolean])
    ): Self = StObject.set(x, "canDrag", value.asInstanceOf[js.Any])

    @scala.inline
    def setCanDragFunction1(value: /* monitor */ DragSourceMonitor[DragObject, DropResult] => Boolean): Self =
      StObject.set(x, "canDrag", js.Any.fromFunction1(value))

    @scala.inline
    def setCanDragUndefined: Self = StObject.set(x, "canDrag", js.undefined)

    @scala.inline
    def setCollect(value: /* monitor */ DragSourceMonitor[DragObject, DropResult] => CollectedProps): Self =
      StObject.set(x, "collect", js.Any.fromFunction1(value))

    @scala.inline
    def setCollectUndefined: Self = StObject.set(x, "collect", js.undefined)

    @scala.inline
    def setEnd(
        value: ( /* draggedItem */ DragObject, /* monitor */ DragSourceMonitor[DragObject, DropResult]) => Unit
    ): Self =
      StObject.set(
        x,
        "end",
        js.Any.fromFunction2(value)
      )

    @scala.inline
    def setEndUndefined: Self = StObject.set(x, "end", js.undefined)

    @scala.inline
    def setIsDragging(value: /* monitor */ DragSourceMonitor[DragObject, DropResult] => Boolean): Self =
      StObject.set(x, "isDragging", js.Any.fromFunction1(value))

    @scala.inline
    def setIsDraggingUndefined: Self = StObject.set(x, "isDragging", js.undefined)

    @scala.inline
    def setItem(value: DragObject | DragObjectFactory[DragObject, DropResult]): Self =
      StObject.set(x, "item", value.asInstanceOf[js.Any])

    @scala.inline
    def setItemFunction1(value: /* monitor */ DragSourceMonitor[DragObject, js.Any] => DragObject | Null): Self =
      StObject.set(x, "item", js.Any.fromFunction1(value))

    @scala.inline
    def setItemUndefined: Self = StObject.set(x, "item", js.undefined)

    @scala.inline
    def setOptions(value: DragSourceOptions): Self = StObject.set(x, "options", value.asInstanceOf[js.Any])

    @scala.inline
    def setOptionsUndefined: Self = StObject.set(x, "options", js.undefined)

    @scala.inline
    def setPreviewOptions(value: DragPreviewOptions): Self =
      StObject.set(x, "previewOptions", value.asInstanceOf[js.Any])

    @scala.inline
    def setPreviewOptionsUndefined: Self = StObject.set(x, "previewOptions", js.undefined)

    @scala.inline
    def setType(value: SourceType): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
  }
}

@js.native
trait DropTargetHookSpec[DragObject, DropResult, CollectedProps] extends StObject {

  /**
   * The kinds of dragItems this dropTarget accepts
   */
  var accept: TargetType = js.native

  /**
   * Optional. Use it to specify whether the drop target is able to accept the item. If you want to always allow it, just
   * omit this method. Specifying it is handy if you'd like to disable dropping based on some predicate over props or
   * monitor.getItem(). Note: You may not call monitor.canDrop() inside this method.
   */
  var canDrop: js.UndefOr[
    js.Function2[ /* item */ DragObject, /* monitor */ DropTargetMonitor[_, _], Boolean]
  ] = js.native

  /**
   * A function to collect rendering properties
   */
  var collect: js.UndefOr[js.Function1[ /* monitor */ DropTargetMonitor[_, _], CollectedProps]] = js.native

  /**
   * Optional.
   * Called when a compatible item is dropped on the target. You may either return undefined, or a plain object.
   * If you return an object, it is going to become the drop result and will be available to the drag source in its
   * endDrag method as monitor.getDropResult(). This is useful in case you want to perform different actions
   * depending on which target received the drop. If you have nested drop targets, you can test whether a nested
   * target has already handled drop by checking monitor.didDrop() and monitor.getDropResult(). Both this method and
   * the source's endDrag method are good places to fire Flux actions. This method will not be called if canDrop()
   * is defined and returns false.
   */
  var drop: js.UndefOr[
    js.Function2[ /* item */ DragObject, /* monitor */ DropTargetMonitor[_, _], js.UndefOr[DropResult]]
  ] = js.native

  /**
   * Optional.
   * Called when an item is hovered over the component. You can check monitor.isOver({ shallow: true }) to test whether
   * the hover happens over just the current target, or over a nested one. Unlike drop(), this method will be called even
   * if canDrop() is defined and returns false. You can check monitor.canDrop() to test whether this is the case.
   */
  var hover: js.UndefOr[js.Function2[ /* item */ DragObject, /* monitor */ DropTargetMonitor[_, _], Unit]] = js.native
}
object DropTargetHookSpec {

  @scala.inline
  def apply[DragObject, DropResult, CollectedProps](
      accept: TargetType
  ): DropTargetHookSpec[DragObject, DropResult, CollectedProps] = {
    val __obj = js.Dynamic.literal(accept = accept.asInstanceOf[js.Any])
    __obj.asInstanceOf[DropTargetHookSpec[DragObject, DropResult, CollectedProps]]
  }

  @scala.inline
  implicit class DropTargetHookSpecMutableBuilder[
      Self <: DropTargetHookSpec[_, _, _],
      DragObject,
      DropResult,
      CollectedProps
  ](val x: Self with (DropTargetHookSpec[DragObject, DropResult, CollectedProps]))
      extends AnyVal {

    @scala.inline
    def setAccept(value: TargetType): Self = StObject.set(x, "accept", value.asInstanceOf[js.Any])

    @scala.inline
    def setAcceptVarargs(value: Identifier*): Self = StObject.set(x, "accept", js.Array(value: _*))

    @scala.inline
    def setCanDrop(value: ( /* item */ DragObject, /* monitor */ DropTargetMonitor[_, _]) => Boolean): Self =
      StObject.set(x, "canDrop", js.Any.fromFunction2(value))

    @scala.inline
    def setCanDropUndefined: Self = StObject.set(x, "canDrop", js.undefined)

    @scala.inline
    def setCollect(value: /* monitor */ DropTargetMonitor[_, _] => CollectedProps): Self =
      StObject.set(x, "collect", js.Any.fromFunction1(value))

    @scala.inline
    def setCollectUndefined: Self = StObject.set(x, "collect", js.undefined)

    @scala.inline
    def setDrop(
        value: ( /* item */ DragObject, /* monitor */ DropTargetMonitor[_, _]) => js.UndefOr[DropResult]
    ): Self = StObject.set(x, "drop", js.Any.fromFunction2(value))

    @scala.inline
    def setDropUndefined: Self = StObject.set(x, "drop", js.undefined)

    @scala.inline
    def setHover(value: ( /* item */ DragObject, /* monitor */ DropTargetMonitor[js.Any, js.Any]) => Unit): Self =
      StObject.set(
        x,
        "hover",
        js.Any.fromFunction2(value)
      )

    @scala.inline
    def setHoverUndefined: Self = StObject.set(x, "hover", js.undefined)

    @scala.inline
    def setOptionsUndefined: Self = StObject.set(x, "options", js.undefined)
  }
}
