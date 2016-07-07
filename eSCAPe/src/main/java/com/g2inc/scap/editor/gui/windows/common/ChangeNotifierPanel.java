package com.g2inc.scap.editor.gui.windows.common;

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

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.g2inc.scap.editor.gui.windows.EditorForm;
import com.g2inc.scap.editor.gui.windows.EditorMainWindow;
import com.g2inc.scap.library.domain.SCAPDocument;
import com.g2inc.scap.library.domain.SCAPDocumentTypeEnum;
import com.g2inc.scap.library.domain.xccdf.XCCDFBenchmark;

public class ChangeNotifierPanel extends javax.swing.JPanel
{
    private static Logger LOG = Logger.getLogger(ChangeNotifierPanel.class);

    private static final long serialVersionUID = 1L;
    private boolean changed = false;
    private List<ChangeListener> changeListeners = new ArrayList<ChangeListener>();
    private JFrame parentWin;
    
    /** Creates new form DefinitionDetailTab */
    public ChangeNotifierPanel()
    {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridBagLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    // End of variables declaration
    public JFrame getParentWin()
    {
        return parentWin;
    }

    public void setParentWin(JFrame parentWin)
    {
        this.parentWin = parentWin;
    }

    public boolean hasChanged()
    {
        return changed;
    }

    public void setChanged(boolean changed)
    {
        this.changed = changed;
    }

    public void addChangeListener(ChangeListener cl)
    {
        if (!changeListeners.contains(cl))
        {
            changeListeners.add(cl);
        }
    }

    public void removeChangeListener(ChangeListener cl)
    {
        if (changeListeners.contains(cl))
        {
            changeListeners.remove(cl);
        }
    }

    public void notifyRegisteredListeners()
    {
        if (changeListeners != null && changeListeners.size() > 0)
        {
            for (int i = 0; i < changeListeners.size(); i++)
            {
                ChangeListener cl = changeListeners.get(i);
                ChangeEvent ce = new ChangeEvent(this);
                cl.stateChanged(ce);
            }
        }
        else
        {
            //LOG.error("No registered listeners.  Calling class = " + getClass().getName());
        }
    }
    
    public XCCDFBenchmark getBenchmark() {
    	XCCDFBenchmark result = null;
    	EditorForm editorForm = EditorMainWindow.getInstance().getActiveEditorForm();
    	if (editorForm != null) {
    		SCAPDocument scapDoc = editorForm.getDocument();
    		if (scapDoc != null) {
    			SCAPDocumentTypeEnum docType = scapDoc.getDocumentType();
    			/*if (docType == SCAPDocumentTypeEnum.XCCDF_114 || docType == SCAPDocumentTypeEnum.XCCDF_12) {
    				return (XCCDFBenchmark) scapDoc;
    			} else {
    				LOG.debug("docType " + docType + " not XCCDF");
    			}*/
    		} else {
    		//	LOG.debug("EDITOR FORM " + editorForm.getClass().getName() + " HAS NO SCAPDocument!");
    		}		
    	} else {
    	//	LOG.debug("NO ACTIVE EDITOR FORM!!");
    	}
    	return result;
    }
}