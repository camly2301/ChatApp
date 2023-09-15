package com.project.swing;

import javax.swing.JProgressBar;

public class Progress extends JProgressBar {

    /**
     * @return the progressType
     */
    public ProgressType getProgressType() {
        return progressType;
    }

    /**
     * @param progressType the progressType to set
     */
    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        repaint();
    }

    private ProgressType progressType = ProgressType.NONE; // gọi hằng NON trong enum 

    public Progress() {
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }

    // enum : chứa các hằng số được IN HOA
    // ProgessType là list các hằng số liên quan đến file
    public static enum ProgressType {
        NONE, DOWN_FILE, CANCEL, FILE 
    }

}
