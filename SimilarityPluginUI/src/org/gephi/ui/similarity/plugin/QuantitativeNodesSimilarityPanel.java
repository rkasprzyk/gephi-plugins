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
package org.gephi.ui.similarity.plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JCheckBox;
import net.miginfocom.swing.MigLayout;
import org.gephi.data.attributes.api.AttributeColumn;
import org.gephi.data.attributes.api.AttributeController;
import org.gephi.data.attributes.api.AttributeOrigin;
import org.gephi.data.attributes.api.AttributeType;
import org.openide.util.Lookup;

/**
 *
 *
 * @author Cezary Bartosiak
 */
public class QuantitativeNodesSimilarityPanel extends javax.swing.JPanel {
	private AttributesCheckBox[] nodeCheckBoxs;

    /** Creates new form QuantitativeNodesSimilarityPanel */
    public QuantitativeNodesSimilarityPanel() {
        initComponents();
    }

	public AttributeColumn[] getColumns() {
		List<AttributeColumn> nodeColumnsList = new ArrayList<AttributeColumn>();
		if (nodeCheckBoxs != null)
			for (AttributesCheckBox c : nodeCheckBoxs)
				if (c.isSelected())
					nodeColumnsList.add(c.getColumn());
		return nodeColumnsList.toArray(new AttributeColumn[0]);
	}

	public void setColumns(AttributeColumn[] columns) {
		AttributeController attributeController = Lookup.getDefault().lookup(AttributeController.class);

		List<AttributeColumn> availableColumns = new ArrayList<AttributeColumn>();
		List<AttributeColumn> selectedColumns = Arrays.asList(columns);
		AttributesCheckBox[] target;
		for (AttributeColumn c : attributeController.getModel().getNodeTable().getColumns())
			if ((c.getOrigin().equals(AttributeOrigin.DATA) || c.getOrigin().equals(AttributeOrigin.COMPUTED)) &&
					(c.getType().equals(AttributeType.BIGDECIMAL) ||
					c.getType().equals(AttributeType.BIGINTEGER) ||
					c.getType().equals(AttributeType.BYTE) ||
					c.getType().equals(AttributeType.DOUBLE) ||
					c.getType().equals(AttributeType.FLOAT) ||
					c.getType().equals(AttributeType.INT) ||
					c.getType().equals(AttributeType.LONG) ||
					c.getType().equals(AttributeType.SHORT) ||
					c.getType().equals(AttributeType.LIST_BIGDECIMAL) ||
					c.getType().equals(AttributeType.LIST_BIGINTEGER) ||
					c.getType().equals(AttributeType.LIST_BYTE) ||
					c.getType().equals(AttributeType.LIST_DOUBLE) ||
					c.getType().equals(AttributeType.LIST_FLOAT) ||
					c.getType().equals(AttributeType.LIST_INTEGER) ||
					c.getType().equals(AttributeType.LIST_LONG) ||
					c.getType().equals(AttributeType.LIST_SHORT)))
				availableColumns.add(c);

		nodeCheckBoxs = new AttributesCheckBox[availableColumns.size()];
		target = nodeCheckBoxs;

		contentPanel.removeAll();
		contentPanel.setLayout(new MigLayout("", "[pref!]"));
		for (int i = 0; i < availableColumns.size(); i++) {
			AttributeColumn column = availableColumns.get(i);
			AttributesCheckBox c = new AttributesCheckBox(column, selectedColumns.contains(column));
			target[i] = c;
			contentPanel.add(c.getCheckBox(), "wrap");
		}
		contentPanel.revalidate();
		contentPanel.repaint();
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vf2Header = new org.jdesktop.swingx.JXHeader();
        columnsLabel = new javax.swing.JLabel();
        contentScrollPane = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(458, 305));

        vf2Header.setDescription(org.openide.util.NbBundle.getMessage(QuantitativeNodesSimilarityPanel.class, "QuantitativeNodesSimilarityPanel.vf2Header.description")); // NOI18N
        vf2Header.setTitle(org.openide.util.NbBundle.getMessage(QuantitativeNodesSimilarityPanel.class, "QuantitativeNodesSimilarityPanel.vf2Header.title")); // NOI18N

        columnsLabel.setText(org.openide.util.NbBundle.getMessage(QuantitativeNodesSimilarityPanel.class, "QuantitativeNodesSimilarityPanel.columnsLabel.text")); // NOI18N

        contentPanel.setLayout(new java.awt.GridLayout());
        contentScrollPane.setViewportView(contentPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vf2Header, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(columnsLabel))
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(vf2Header, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(columnsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel columnsLabel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JScrollPane contentScrollPane;
    private org.jdesktop.swingx.JXHeader vf2Header;
    // End of variables declaration//GEN-END:variables

	private static class AttributesCheckBox {
		private JCheckBox checkBox;
		private AttributeColumn column;

		public AttributesCheckBox(AttributeColumn column, boolean selected) {
			checkBox = new JCheckBox(column.getTitle(), selected);
			this.column = column;
		}

		public void setSelected(boolean selected) {
			checkBox.setSelected(selected);
		}

		public boolean isSelected() {
			return checkBox.isSelected();
		}

		public JCheckBox getCheckBox() {
			return checkBox;
		}

		public AttributeColumn getColumn() {
			return column;
		}
	}
}
