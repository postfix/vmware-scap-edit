package com.g2inc.scap.editor.gui.dialogs.editors.cpe.item.reference;
/* ESCAPE Software Copyright 2010 G2, Inc. - All rights reserved.
*
* ESCAPE is open source software distributed under GNU General Public License Version 3.  ESCAPE is not in the public domain 
* and G2, Inc. holds its copyright.  Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:

* 1. Redistributions of ESCAPE source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
* 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the ESCAPE Software distribution. 
* 3. Neither the name of G2, Inc. nor the names of any contributors may be used to endorse or promote products derived from this software without specific prior written permission. 

* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,
* INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
* IN NO EVENT SHALL G2, INC., THE AUTHORS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
* OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
* OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
* POSSIBILITY OF SUCH DAMAGE.

* You should have received a copy of the GNU General Public License Version 3 along with this program. 
* If not, see http://www.gnu.org/licenses/ for a copy.
*/

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.g2inc.scap.editor.gui.dialogs.editors.EditorDialog;
import com.g2inc.scap.editor.gui.dialogs.editors.IEditorPage;
import com.g2inc.scap.library.domain.cpe.CPEItemReference;

public class CPEItemReferenceEditor extends javax.swing.JPanel implements IEditorPage
{

    private EditorDialog parentEditor = null;
    private CPEItemReference reference = null;
    private DocumentListener textDocumentlistener = null;

    private void initTextFields()
    {
        textDocumentlistener = new DocumentListener()
        {
            private void common(DocumentEvent e)
            {
                String t = hrefTextField.getText();

                if (t != null && t.length() > 0)
                {
                    if(reference != null)
                    {
                        reference.setHref(t);
                    }

                    parentEditor.enableOkButton();
                } else
                {
                    parentEditor.disableOkButton();
                }
            }

            public void insertUpdate(DocumentEvent e)
            {
                common(e);
            }

            public void removeUpdate(DocumentEvent e)
            {
                common(e);
            }

            public void changedUpdate(DocumentEvent e)
            {
                common(e);
            }
        };
    }

    private void initComponents2()
    {
        initTextFields();
    }

    /** Creates new form RegexDatatypeEditor */
    public CPEItemReferenceEditor()
    {
        initComponents();
        initComponents2();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        hrefCaption = new javax.swing.JLabel();
        hrefTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        hrefCaption.setText("Href");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 3, 5);
        add(hrefCaption, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 5, 8);
        add(hrefTextField, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hrefCaption;
    private javax.swing.JTextField hrefTextField;
    // End of variables declaration//GEN-END:variables

    public CPEItemReference getData()
    {
        return reference;
    }

    public void setEditorDialog(EditorDialog editorDialog)
    {
        parentEditor = editorDialog;
        parentEditor.setTitle("Reference Editor");
    }

    public void setData(Object data)
    {
        if (data == null)
        {
            throw new IllegalStateException("setData(Object data) must be called with a non-null item reference");
        }

        reference = (CPEItemReference) data;

        String hrefTxt = reference.getHref();

        if(hrefTxt != null)
        {
            hrefTextField.setText(hrefTxt);
        }

        hrefTextField.getDocument().addDocumentListener(textDocumentlistener);
        hrefTextField.requestFocus();
    }
}