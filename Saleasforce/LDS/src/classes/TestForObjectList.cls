@isTest
private class TestForObjectList {
	@isTest static void testSchema() {
        List<Schema.SObjectType> schemaList=ObjectList.listobjects();
        System.assertEquals(360,schemaList.size());
    }
}