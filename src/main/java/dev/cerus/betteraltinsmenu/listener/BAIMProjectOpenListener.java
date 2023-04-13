package dev.cerus.betteraltinsmenu.listener;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import dev.cerus.betteraltinsmenu.service.BAIMService;
import org.jetbrains.annotations.NotNull;

public class BAIMProjectOpenListener implements ProjectManagerListener {

    @Override
    public void projectOpened(@NotNull final Project project) {
        BAIMService.getInstance().applySettings();
    }

}
