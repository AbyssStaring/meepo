/**
 * Copyright 2014-2017 yangming.liu<bytefox@126.com>.
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, see <http://www.gnu.org/licenses/>.
 */

package org.feisoft.jta;

import org.feisoft.transaction.CommitRequiredException;
import org.feisoft.transaction.RollbackRequiredException;

import javax.transaction.HeuristicCommitException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import javax.transaction.xa.XAException;
import javax.transaction.xa.Xid;

public interface TransactionStrategy {

    int TRANSACTION_STRATEGY_VACANT = 0;
    int TRANSACTION_STRATEGY_SIMPLE = 1;
    int TRANSACTION_STRATEGY_COMMON = 2;
    int TRANSACTION_STRATEGY_LRO = 3;

    int start(Xid xid) throws RollbackRequiredException, CommitRequiredException;

    int prepare(Xid xid) throws XAException;

    void commit(Xid xid)
            throws HeuristicMixedException, HeuristicRollbackException, IllegalStateException, SystemException;

    void rollback(Xid xid)
            throws HeuristicMixedException, HeuristicCommitException, IllegalStateException, SystemException;

}
