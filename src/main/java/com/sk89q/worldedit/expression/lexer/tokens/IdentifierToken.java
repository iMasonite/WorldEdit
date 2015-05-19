// $Id$
/*
 * WorldEdit Copyright (C) 2010, 2011 sk89q <http://www.sk89q.com> and contributors This program is
 * free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.expression.lexer.tokens;

/** An identifier
 * 
 * @author TomyLobo */
public class IdentifierToken extends Token {
	public final String value;
	
	public IdentifierToken(int position, String value) {
		super(position);
		this.value = value;
	}
	
	@Override
	public char id() {
		return 'i';
	}
	
	@Override
	public String toString() {
		return "IdentifierToken(" + value + ")";
	}
}
