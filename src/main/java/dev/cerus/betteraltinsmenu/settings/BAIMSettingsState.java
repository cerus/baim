package dev.cerus.betteraltinsmenu.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import dev.cerus.betteraltinsmenu.service.BAIMService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "dev.cerus.betteraltinsmenu.settings.AppSettingsState",
        storages = @Storage("BAIMSettings.xml")
)
public class BAIMSettingsState implements PersistentStateComponent<BAIMSettingsState> {

    public Mode mode = Mode.REMOVE;

    public static BAIMSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(BAIMSettingsState.class);
    }

    @Override
    public @Nullable BAIMSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull final BAIMSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
        BAIMService.getInstance().applySettings();
    }

    public enum Mode {
        KEEP("Keep menu as is"),
        MOVE_TO_BOTTOM("Move \"Add dependency\" to bottom of menu"),
        REMOVE("Remove \"Add dependency\" from menu");

        private final String text;

        Mode(final String text) {
            this.text = text;
        }

        public String text() {
            return this.text;
        }

    }

}
