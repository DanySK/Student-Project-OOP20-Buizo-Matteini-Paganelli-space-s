package spacesurvival.model.gui.pause;

import spacesurvival.utilities.LinkActionGUI;

/**
 * LinksPause contains pause links with buttons.
 */
public enum LinksPause {
    /**
     * Link to GUI game.
     */
    RESUME_BUTTON("Resume", LinkActionGUI.ID_GAME),

    /**
     * Link to GUI sound.
     */
    SOUND_BUTTON("Sound", LinkActionGUI.ID_SOUND),

    /**
     * Link to GUI help.
     */
    HELP_BUTTON("Help", LinkActionGUI.ID_HELP),

    /**
     * Link to GUI quit.
     */
    QUIT_BUTTON("Quit", LinkActionGUI.ID_QUIT);

    private final String text;
    private final LinkActionGUI linkActionGUI;

    /**
     * Create link for menu GUI to a other GUI.
     * @param name other GUI.
     * @param linkActionGUI
     */
    LinksPause(final String text, final LinkActionGUI linkActionGUI) {
        this.text = text;
        this.linkActionGUI = linkActionGUI;
    }

    public String getText() {
        return this.text;
    }

    public LinkActionGUI getIdGUI() {
        return this.linkActionGUI;
    }
}
