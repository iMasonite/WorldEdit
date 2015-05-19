
package com.sk89q.worldedit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.blocks.BlockID;

public class CuboidClipboardTest {
	@Test
	public void testFlipCenterPlane() throws Exception {
		// testFlip(0, 1, CuboidClipboard.FlipDirection.UP_DOWN);
		// testFlip(2, 3, CuboidClipboard.FlipDirection.NORTH_SOUTH);
		// testFlip(4, 5, CuboidClipboard.FlipDirection.WEST_EAST);
	}
	
	@SuppressWarnings("unused")
	private void testFlip(int data, int expectedDataAfterFlip, CuboidClipboard.FlipDirection flipDirection) {
		final CuboidClipboard clipboard = new CuboidClipboard(new Vector(1, 1, 1));
		clipboard.setBlock(Vector.ZERO, new BaseBlock(BlockID.PISTON_BASE, data));
		clipboard.flip(flipDirection);
		assertEquals(expectedDataAfterFlip, clipboard.getBlock(Vector.ZERO).getData());
	}
}
