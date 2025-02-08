package com.onixbyte.zuan.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

public class ZuanTableDef extends TableDef {

    public static final ZuanTableDef ZUAN = new ZuanTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn TEXT = new QueryColumn(this, "text");

    public final QueryColumn LEVEL = new QueryColumn(this, "level");

    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, TEXT, LEVEL};

    public ZuanTableDef() {
        super("", "zuan");
    }

    public ZuanTableDef(String schema, String tableName, String alias) {
        super(schema, tableName, alias);
    }

    public ZuanTableDef as(String alias) {
        var key = getNameWithSchema() + "." + alias;
        return getCache(key, (k) -> new ZuanTableDef("", "zuan", alias));
    }
}
