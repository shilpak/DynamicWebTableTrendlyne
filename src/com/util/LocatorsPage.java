package com.util;

import com.base.TestBase;

public class LocatorsPage extends TestBase{
	
	public static String webTable = "table[class*='tl-dataTable']";
	public static String webTableRowCount = "table[class*='tl-dataTable']>tbody>tr";
	public static String webTableFirstColumn = "table[class*='tl-dataTable']>tbody>tr>td:nth-child(1)";
	public static String lastListElement = "div[class*='dataTables_paginate paging_simple_numbers']>ul>li:last-child";

}

