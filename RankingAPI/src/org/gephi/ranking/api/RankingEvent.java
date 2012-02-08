/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */
package org.gephi.ranking.api;

/**
 * Event generated by the {@link RankingModel} and sent to listeners registered
 * by the model.
 * <p>
 * The types of events:
 * <ul>
 * <li><b>REFRESH_RANKING:</b> The list of available ranking has been
 * updated. The listeners can call <code>RankingModel.getRankings()</code>
 * to get the newly created rankings</li>
 * <li><b>APPLY_TRANSFORMER:</b> A transformer has just been applied. The listeners
 * can retried the transformer and ranking directly from the event.</li>
 * <li><b>START_AUTO_TRANSFORM:</b> A auto transformer has just been started.</li>
 * <li><b>STOP_AUTO_TRANSFORM:</b> A auto transformer has just been stopped.</li>
 * </ul>
 * 
 * @see RankingListener
 * @author Mathieu Bastian
 */
public interface RankingEvent {

    /**
     * <ul>
     * <li><b>REFRESH_RANKING:</b> The list of available ranking has been
     * updated. The listeners can call <code>RankingModel.getRankings()</code>
     * to get the newly created rankings</li>
     * <li><b>APPLY_TRANSFORMER:</b> A transformer has just been applied. The listeners
     * can retried the transformer and ranking directly from the event.</li>
     * <li><b>START_AUTO_TRANSFORM:</b> A auto transformer has just been started.</li>
     * <li><b>STOP_AUTO_TRANSFORM:</b> A auto transformer has just been stopped.</li>
     * </ul>
     */
    public enum EventType {

        REFRESH_RANKING, APPLY_TRANSFORMER, START_AUTO_TRANSFORM, STOP_AUTO_TRANSFORM
    };

    /**
     * Returns the type of event.
     * @return the type of this event
     */
    public EventType getEventType();

    /**
     * Returns the ranking model that generated the event.
     * @return the source of the event
     */
    public RankingModel getSource();

    /**
     * Returns the ranking associated to the event, or <code>null</code>.
     * @return the ranking associated to the event or <code>null</code>
     */
    public Ranking getRanking();

    /**
     * Returns the transformer associated to the event, or <code>null</code>.
     * @return the ranking associated to the event or <code>null</code> 
     */
    public Transformer getTransformer();

    /**
     * Returns <code>true</code> if this event is one of these in parameters.
     * @param type  the event types that are to be compared with this event
     * @return      <code>true</code> if this event is <code>type</code>,
     *              <code>false</code> otherwise
     */
    public boolean is(EventType... type);
}
