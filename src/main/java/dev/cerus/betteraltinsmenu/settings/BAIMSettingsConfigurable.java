package dev.cerus.betteraltinsmenu.settings;

import com.intellij.openapi.options.Configurable;
import dev.cerus.betteraltinsmenu.service.BAIMService;
import javax.swing.JComponent;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

public class BAIMSettingsConfigurable implements Configurable {

    private BAIMSettingsComponent component;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Better Alt+Ins Menu Settings";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return this.component.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        this.component = new BAIMSettingsComponent();
        return this.component.getPanel();
    }

    @Override
    public boolean isModified() {
        final BAIMSettingsState settings = BAIMSettingsState.getInstance();
        return this.component.getSelectedMode() != settings.mode;
    }

    @Override
    public void apply() {
        final BAIMSettingsState settings = BAIMSettingsState.getInstance();
        settings.mode = this.component.getSelectedMode();

        BAIMService.getInstance().applySettings();
    }

    @Override
    public void reset() {
        final BAIMSettingsState settings = BAIMSettingsState.getInstance();
        this.component.setSelectedMode(settings.mode);
    }

    @Override
    public void disposeUIResources() {
        this.component = null;
    }

}
