/*
 * Copyright 2008-2010 Gephi
 * Authors : Cezary Bartosiak
 * Website : http://www.gephi.org
 *
 * This file is part of Gephi.
 *
 * Gephi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Gephi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.ui.complexgenerator.plugin;

import org.gephi.lib.validation.PositiveNumberValidator;
import org.netbeans.validation.api.Problems;
import org.netbeans.validation.api.Validator;
import org.netbeans.validation.api.builtin.Validators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.ValidationPanel;

/**
 *
 *
 * @author Cezary Bartosiak
 */
public class BarabasiAlbertPanel extends javax.swing.JPanel {

    /** Creates new form BarabasiAlbertPanel */
    public BarabasiAlbertPanel() {
        initComponents();
    }

	public static ValidationPanel createValidationPanel(BarabasiAlbertPanel innerPanel) {
		ValidationPanel validationPanel = new ValidationPanel();
		if (innerPanel == null)
			innerPanel = new BarabasiAlbertPanel();
		validationPanel.setInnerComponent(innerPanel);

		ValidationGroup group = validationPanel.getValidationGroup();

		group.add(innerPanel.NField, Validators.REQUIRE_NON_EMPTY_STRING,
				new PositiveNumberValidator());
		group.add(innerPanel.m0Field, Validators.REQUIRE_NON_EMPTY_STRING,
				new PositiveNumberValidator());
		group.add(innerPanel.m0Field, Validators.REQUIRE_NON_EMPTY_STRING,
				new m0Validator(innerPanel));
		group.add(innerPanel.MField, Validators.REQUIRE_NON_EMPTY_STRING,
				new PositiveNumberValidator());
		group.add(innerPanel.MField, Validators.REQUIRE_NON_EMPTY_STRING,
				new MValidator(innerPanel));

		return validationPanel;
	}

	private static class m0Validator implements Validator<String> {
		private BarabasiAlbertPanel innerPanel;

		public m0Validator(BarabasiAlbertPanel innerPanel) {
			this.innerPanel = innerPanel;
		}

		@Override
		public boolean validate(Problems problems, String compName, String model) {
			boolean result = false;

			try {
				Integer N  = Integer.parseInt(innerPanel.NField.getText());
				Integer m0 = Integer.parseInt(innerPanel.m0Field.getText());
				result = m0 < N;
			}
			catch (Exception e) { }
			if (!result) {
				String message = "<html>m0 &lt; N</html>";
				problems.add(message);
			}

			return result;
		}
    }

	private static class MValidator implements Validator<String> {
		private BarabasiAlbertPanel innerPanel;

		public MValidator(BarabasiAlbertPanel innerPanel) {
			this.innerPanel = innerPanel;
		}

		@Override
		public boolean validate(Problems problems, String compName, String model) {
			boolean result = false;

			try {
				Integer m0 = Integer.parseInt(innerPanel.m0Field.getText());
				Integer M  = Integer.parseInt(innerPanel.MField.getText());
				result = M <= m0;
			}
			catch (Exception e) { }
			if (!result) {
				String message = "<html>M &lt;= m0</html>";
				problems.add(message);
			}

			return result;
		}
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MLabel = new javax.swing.JLabel();
        MField = new javax.swing.JTextField();
        NField = new javax.swing.JTextField();
        m0Field = new javax.swing.JTextField();
        NLabel = new javax.swing.JLabel();
        m0Label = new javax.swing.JLabel();
        constraintsLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(451, 170));

        MLabel.setText(org.openide.util.NbBundle.getMessage(BarabasiAlbertPanel.class, "BarabasiAlbertPanel.MLabel.text")); // NOI18N

        MField.setText(org.openide.util.NbBundle.getMessage(BarabasiAlbertPanel.class, "BarabasiAlbertPanel.MField.text")); // NOI18N

        NField.setText(org.openide.util.NbBundle.getMessage(BarabasiAlbertPanel.class, "BarabasiAlbertPanel.NField.text")); // NOI18N

        m0Field.setText(org.openide.util.NbBundle.getMessage(BarabasiAlbertPanel.class, "BarabasiAlbertPanel.m0Field.text")); // NOI18N

        NLabel.setText(org.openide.util.NbBundle.getMessage(BarabasiAlbertPanel.class, "BarabasiAlbertPanel.NLabel.text")); // NOI18N

        m0Label.setText(org.openide.util.NbBundle.getMessage(BarabasiAlbertPanel.class, "BarabasiAlbertPanel.m0Label.text")); // NOI18N

        constraintsLabel.setText(org.openide.util.NbBundle.getMessage(BarabasiAlbertPanel.class, "BarabasiAlbertPanel.constraintsLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(constraintsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NLabel)
                        .addComponent(m0Label)
                        .addComponent(MLabel)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(m0Field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(MField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(NField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m0Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m0Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(constraintsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextField MField;
    private javax.swing.JLabel MLabel;
    protected javax.swing.JTextField NField;
    private javax.swing.JLabel NLabel;
    private javax.swing.JLabel constraintsLabel;
    protected javax.swing.JTextField m0Field;
    private javax.swing.JLabel m0Label;
    // End of variables declaration//GEN-END:variables

}
