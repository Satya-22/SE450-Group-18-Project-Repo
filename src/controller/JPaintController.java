package controller;


import controller.commandPattern.StaticFactory;
import model.interfaces.IApplicationState;
import model.interfaces.IJPaintController;
import view.EventName;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

public class JPaintController implements IJPaintController {
	private final IUiModule uiModule;
	private final IApplicationState applicationState;

	private final PaintCanvasBase paintCanvas;

	public JPaintController(IUiModule uiModule, IApplicationState applicationState,PaintCanvasBase paintCanvas) {
		this.uiModule = uiModule;
		this.applicationState = applicationState;
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void setup() {
		setupEvents();
	}

	private void setupEvents() {
		uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
		uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
		uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
		uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
		uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
		uiModule.addEvent(EventName.UNDO, () -> CommandHistory.undo());
		uiModule.addEvent(EventName.REDO, () -> CommandHistory.redo());
		uiModule.addEvent(EventName.COPY, () -> StaticFactory.copyCommand().run());
		uiModule.addEvent(EventName.PASTE, () -> StaticFactory.pasteCommand(paintCanvas).run());
		uiModule.addEvent(EventName.DELETE, () -> StaticFactory.deleteCommand().run());
		uiModule.addEvent(EventName.GROUP, () -> StaticFactory.groupCommand(paintCanvas,applicationState).run());
		uiModule.addEvent(EventName.UNGROUP,() -> StaticFactory.ungroupCommand().run());
	}
}
