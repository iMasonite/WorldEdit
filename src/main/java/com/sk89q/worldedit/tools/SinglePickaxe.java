// $Id$
/*
 * WorldEdit Copyright (C) 2010 sk89q <http://www.sk89q.com> and contributors This program is free
 * software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version. This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.tools;

import com.sk89q.worldedit.LocalConfiguration;
import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.ServerInterface;
import com.sk89q.worldedit.WorldVector;
import com.sk89q.worldedit.blocks.BlockID;

/** A super pickaxe mode that removes one block.
 * 
 * @author sk89q */
public class SinglePickaxe implements BlockTool {
	
	@Override
	public boolean canUse(LocalPlayer player) {
		return player.hasPermission("worldedit.superpickaxe");
	}
	
	@Override
	public boolean actPrimary(ServerInterface server, LocalConfiguration config, LocalPlayer player, LocalSession session, WorldVector clicked) {
		LocalWorld world = clicked.getWorld();
		
		final int blockType = world.getBlockType(clicked);
		if (blockType == BlockID.BEDROCK && !player.canDestroyBedrock()) return true;
		
		if (config.superPickaxeDrop) {
			world.simulateBlockMine(clicked);
		}
		
		world.setBlockType(clicked, BlockID.AIR);
		
		world.playEffect(clicked, 2001, blockType);
		
		return true;
	}
	
}
