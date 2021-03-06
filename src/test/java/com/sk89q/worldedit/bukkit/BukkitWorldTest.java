/*
 * WorldEdit Copyright (C) 2012 sk89q <http://www.sk89q.com> This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version. This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.bukkit;

import org.junit.Assert;
import org.junit.Test;

import com.sk89q.worldedit.util.TreeGenerator;

/** @author zml2008 */
public class BukkitWorldTest {
	@Test
	public void testTreeTypeMapping() {
		for (TreeGenerator.TreeType type : TreeGenerator.TreeType.values()) {
			Assert.assertFalse("No mapping for: " + type, BukkitWorld.toBukkitTreeType(type) == null);
		}
	}
}
