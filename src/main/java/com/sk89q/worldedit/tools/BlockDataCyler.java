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
import com.sk89q.worldedit.blocks.BaseBlock;

/** A mode that cycles the data values of supported blocks.
 * 
 * @author sk89q */
public class BlockDataCyler implements DoubleActionBlockTool {
	
	@Override
	public boolean canUse(LocalPlayer player) {
		return player.hasPermission("worldedit.tool.data-cycler");
	}
	
	private boolean handleCycle(ServerInterface server, LocalConfiguration config, LocalPlayer player, LocalSession session, WorldVector clicked, boolean forward) {
		
		LocalWorld world = clicked.getWorld();
		
		int type = world.getBlockType(clicked);
		int data = world.getBlockData(clicked);
		
		if (config.allowedDataCycleBlocks.size() > 0 && !player.hasPermission("worldedit.override.data-cycler") && !config.allowedDataCycleBlocks.contains(type)) {
			player.printError("You are not permitted to cycle the data value of that block.");
			return true;
		}
		
		int increment = forward ? 1 : -1;
		data = (new BaseBlock(type, data)).cycleData(increment);
		
		if (data < 0) {
			player.printError("That block's data cannot be cycled!");
		}
		else {
			world.setBlockData(clicked, data);
		}
		
		return true;
	}
	
	@Override
	public boolean actPrimary(ServerInterface server, LocalConfiguration config, LocalPlayer player, LocalSession session, WorldVector clicked) {
		return handleCycle(server, config, player, session, clicked, true);
	}
	
	@Override
	public boolean actSecondary(ServerInterface server, LocalConfiguration config, LocalPlayer player, LocalSession session, WorldVector clicked) {
		return handleCycle(server, config, player, session, clicked, false);
	}
	
}
