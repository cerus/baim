package dev.cerus.betteraltinsmenu.settings;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class BAIMSettingsComponent {

    private final JPanel mainPanel;
    private final ComboBox<BAIMSettingsState.Mode> modeList;

    public BAIMSettingsComponent() {
        this.modeList = new ComboBox<>();
        for (final BAIMSettingsState.Mode mode : BAIMSettingsState.Mode.values()) {
            this.modeList.addItem(mode);
        }
        this.modeList.setRenderer(new BAIMSettingsModeRenderer());

        this.mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Behaviour: "), this.modeList, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return this.mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return this.modeList;
    }

    public BAIMSettingsState.Mode getSelectedMode() {
        return (BAIMSettingsState.Mode) this.modeList.getSelectedItem();
    }

    public void setSelectedMode(final BAIMSettingsState.Mode mode) {
        this.modeList.setSelectedIndex(mode.ordinal());
    }

    private static class BAIMSettingsModeRenderer implements ListCellRenderer<BAIMSettingsState.Mode> {

        @Override
        public Component getListCellRendererComponent(final JList<? extends BAIMSettingsState.Mode> list,
                                                      final BAIMSettingsState.Mode value,
                                                      final int index,
                                                      final boolean isSelected,
                                                      final boolean cellHasFocus) {
            return new JBLabel(value.text());
        }

    }

}
