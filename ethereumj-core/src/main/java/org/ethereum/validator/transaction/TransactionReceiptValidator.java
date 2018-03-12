/*
 * Copyright (c) [2016] [ <ether.camp> ]
 * This file is part of the ethereumJ library.
 *
 * The ethereumJ library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The ethereumJ library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the ethereumJ library. If not, see <http://www.gnu.org/licenses/>.
 */
package org.ethereum.validator.transaction;

import org.ethereum.core.TransactionReceipt;
import org.ethereum.validator.EntityValidator;

import java.util.List;

/**
 * Composite {@link TransactionReceipt} validator
 * aggregating list of simple validation rules
 */
public class TransactionReceiptValidator extends EntityValidator<TransactionReceiptRule, TransactionReceipt> {

    public TransactionReceiptValidator(List<TransactionReceiptRule> rules) {
        super(rules);
    }

    public TransactionReceiptValidator(TransactionReceiptRule... rules) {
        super(rules);
    }

    @Override
    public Class getEntityClass() {
        return TransactionReceipt.class;
    }
}