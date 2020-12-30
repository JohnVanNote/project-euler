package com.jvn;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximumPathSum_UnitTest {

  @Test
  public void findMaximumPath_tree_maxPath() {
    List<List<Integer>> tree = ImmutableList.of(
        ImmutableList.of(3),
        ImmutableList.of(7, 4),
        ImmutableList.of(2, 4, 6),
        ImmutableList.of(8, 5, 9, 3)
    );

    Assert.assertEquals(MaximumPathSum.findMaximumPath(tree), 23);
  }

}
