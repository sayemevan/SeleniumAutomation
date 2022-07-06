package com.ababil.generic.actions.services.objectServices;

public interface WebtableActions {

    boolean WebTableIdentitySet(String UniqueColumnNameOnPage, String ColumnIndex, String OutIdentityString, String ExtraParam);

    boolean WebTableCellLocationGet(String WebTableObjName, String RefSearchText, String InstanceNo, String RefColName, String CellColName, String OutCellRowId, String OutCellColumnId, String ExtraParam);

    boolean WebTableCellActionSet(String WebTableObjName, String CellRowIdentity, String CellColumnIdentity, String CellObjectType, String CellActionType, String ValueToBeSet, String ExtraParam);

    boolean WebTableCellValueGet(String WebTableObjName, String CellRowIdentity, String CellColumnIdentity, String CellObjectType, String PropertyName, String OutCellValue, String ExtraParam);

    boolean WebTableRowColumnCountGet(String WebTableObjName, String OutRowCount, String OutColumnCount, String ExtraParam);

    boolean WebTablePaginatorSet(String WebTableObjName, String PageNumOrNavDirection, String NavRepeatCount, String OutCurrPageValue, String ExtraParam);

    boolean WebTableColSortOrderVerify(String WebTableObjName, String ColumnName, String SortOrderType, String ValueType, String CaseSensitivity, String ExtraParam);

    boolean WebTableDataValidate(String DataSheetName, String RowMarkingTags, String RepeatLoopCount, String ExtraParam);
}
