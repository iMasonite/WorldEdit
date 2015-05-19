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

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.LocalConfiguration;
import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.ServerInterface;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldVector;
import com.sk89q.worldedit.bags.BlockBag;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.blocks.BlockType;

/** A mode that replaces one block.
 * 
 * @author sk89q */
public class BlockReplacer implements DoubleActionBlockTool {
	private BaseBlock targetBlock;
	
	public BlockReplacer(BaseBlock targetBlock) {
		this.targetBlock = targetBlock;
	}
	
	@Override
	public boolean canUse(LocalPlayer player) {
		return player.hasPermission("worldedit.tool.replacer");
	}
	
	@Override
	public boolean actPrimary(ServerInterface server, LocalConfiguration config, LocalPlayer player, LocalSession session, WorldVector clicked) {
		
		BlockBag bag = session.getBlockBag(player);
		
		LocalWorld world = clicked.getWorld();
		EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(world, -1, bag, player);
		
		try {
			editSession.setBlock(clicked, targetBlock);
		}
		catch (MaxChangedBlocksException e) {
		}
		finally {
			if (bag != null) {
				bag.flushChanges();
			}
			session.remember(editSession);
		}
		
		return true;
	}
	
	@Override
	public boolean actSecondary(ServerInterface server, LocalConfiguration config, LocalPlayer player, LocalSession session, WorldVector clicked) {
		
		LocalWorld world = clicked.getWorld();
		EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(world, -1, player);
		targetBlock = (editSession).getBlock(clicked);
		BlockType type = BlockType.fromID(targetBlock.getType());
		
		if (type != null) {
			player.print("Replacer tool switched to: " + type.getName());
		}
		
		return true;
	}
	
}
