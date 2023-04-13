package dev.cerus.betteraltinsmenu.service;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.Service;
import dev.cerus.betteraltinsmenu.settings.BAIMSettingsState;

@Service(Service.Level.APP)
public final class BAIMService {

    private static final String ADD_DEP_ACTION_ID = "com.jetbrains.packagesearch.intellij.plugin.actions.AddDependencyAction";
    private static final String GEN_GROUP_ACTION_ID = "GenerateGroup";

    public static BAIMService getInstance() {
        return ApplicationManager.getApplication().getService(BAIMService.class);
    }

    /**
     * Apply the "Better Alt+Ins Menu" settings to IntelliJ
     */
    public void applySettings() {
        final BAIMSettingsState settingsState = BAIMSettingsState.getInstance();
        final ActionManager actionManager = ActionManager.getInstance();

        final AnAction addDepAction = actionManager.getAction(ADD_DEP_ACTION_ID);
        if (addDepAction == null) {
            // Abort if "Add dependency" action is not present
            return;
        }

        final AnAction genGroup = actionManager.getAction(GEN_GROUP_ACTION_ID);
        if (!(genGroup instanceof DefaultActionGroup)) {
            // Abort if Generate-group is not present
            return;
        }

        final DefaultActionGroup group = (DefaultActionGroup) genGroup;
        group.remove(addDepAction);
        switch (settingsState.mode) {
            case KEEP:
                group.add(addDepAction, Constraints.FIRST);
                break;
            case MOVE_TO_BOTTOM:
                group.add(addDepAction, Constraints.LAST);
                break;
            case REMOVE:
                // Already removed, do nothing
                break;
        }
    }

}
