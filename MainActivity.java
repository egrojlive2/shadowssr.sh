package com.d2rey.ang.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.d2rey.ang.AppConfig;
import com.d2rey.ang.InappBuyActivity;
import com.d2rey.ang.R;
import com.d2rey.ang.dto.AngConfig;
import com.d2rey.ang.helper.SimpleItemTouchHelperCallback;
import com.d2rey.ang.util.AngConfigManager;
import com.d2rey.ang.util.MessageUtil;
import com.d2rey.ang.util.Utils;
import com.d2rey.ang.util.V2rayConfigUtil;
import com.github.jorgecastilloprz.FABProgressCircle;
import com.tbruyelle.rxpermissions.RxPermissions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.anko.AsyncKt;
import org.jetbrains.anko.internals.AnkoInternals;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(bv = {MainActivity.REQUEST_SCAN, MainActivity.REQUEST_CODE_VPN_PREPARE, MainActivity.REQUEST_SCAN_URL}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002DEB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u000bJ\u0010\u0010!\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$J\"\u0010%\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0015H\u0016J\u0012\u0010*\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0012\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0016J\b\u00108\u001a\u00020\u0015H\u0016J\b\u00109\u001a\u00020\u0015H\u0016J\b\u0010:\u001a\u00020\u0015H\u0014J\b\u0010;\u001a\u00020\u0015H\u0014J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0018J\u0006\u0010A\u001a\u00020\u0015J\b\u0010B\u001a\u00020\u0015H\u0002J\u0006\u0010C\u001a\u00020\u0015R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/d2rey/ang/ui/MainActivity;", "Lcom/d2rey/ang/ui/BaseActivity;", "Landroid/support/design/widget/NavigationView$OnNavigationItemSelectedListener;", "()V", "adapter", "Lcom/d2rey/ang/ui/MainRecyclerAdapter;", "getAdapter", "()Lcom/d2rey/ang/ui/MainRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "value", "", "isRunning", "()Z", "setRunning", "(Z)V", "mItemTouchHelper", "Landroid/support/v7/widget/helper/ItemTouchHelper;", "mMsgReceive", "Landroid/content/BroadcastReceiver;", "hideCircle", "", "importBatchConfig", "server", "", "subid", "importClipboard", "importConfigCustomClipboard", "importConfigCustomLocal", "importConfigCustomUrl", "url", "importConfigCustomUrlClipboard", "importConfigViaSub", "importCustomizeConfig", "importQRcode", "requestCode", "", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onOptionsItemSelected", "onPause", "onResume", "onStart", "onStop", "readContentFromUri", "uri", "Landroid/net/Uri;", "setTestState", "content", "showCircle", "showFileChooser", "startV2Ray", "Companion", "ReceiveMessageHandler", "app_release"}, k = MainActivity.REQUEST_SCAN, mv = {MainActivity.REQUEST_SCAN, MainActivity.REQUEST_SCAN, 15})
/* compiled from: MainActivity.kt */
public final class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REQUEST_CODE_VPN_PREPARE = 0;
    private static final int REQUEST_FILE_CHOOSER = 2;
    private static final int REQUEST_SCAN = 1;
    private static final int REQUEST_SCAN_URL = 3;
    private HashMap _$_findViewCache;
    private final Lazy adapter$delegate = LazyKt.lazy(new adapter.2(this));
    private boolean isRunning;
    private ItemTouchHelper mItemTouchHelper;
    private BroadcastReceiver mMsgReceive;

    static {
        KProperty[] kPropertyArr = new KProperty[REQUEST_SCAN];
        kPropertyArr[REQUEST_CODE_VPN_PREPARE] = (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MainActivity.class), "adapter", "getAdapter()Lcom/d2rey/ang/ui/MainRecyclerAdapter;"));
        $$delegatedProperties = kPropertyArr;
    }

    /* access modifiers changed from: private */
    public final MainRecyclerAdapter getAdapter() {
        Lazy lazy = this.adapter$delegate;
        KProperty kProperty = $$delegatedProperties[REQUEST_CODE_VPN_PREPARE];
        return (MainRecyclerAdapter) lazy.getValue();
    }

    public static /* synthetic */ void importBatchConfig$default(MainActivity mainActivity, String str, String str2, int i, Object obj) {
        if ((i & REQUEST_FILE_CHOOSER) != 0) {
            str2 = "";
        }
        mainActivity.importBatchConfig(str, str2);
    }

    private final void readContentFromUri(Uri uri) {
        RxPermissions rxPermissions = new RxPermissions((Activity) this);
        String[] strArr = new String[REQUEST_SCAN];
        strArr[REQUEST_CODE_VPN_PREPARE] = "android.permission.READ_EXTERNAL_STORAGE";
        rxPermissions.request(strArr).subscribe(new readContentFromUri.1(this, uri));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity] */
    private final void showFileChooser() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        try {
            startActivityForResult(Intent.createChooser(intent, getString(2131755163)), REQUEST_FILE_CHOOSER);
        } catch (ActivityNotFoundException unused) {
            Toast makeText = Toast.makeText((Context) this, 2131755199, (int) REQUEST_CODE_VPN_PREPARE);
            makeText.show();
            Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void hideCircle() {
        try {
            Observable.timer(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new hideCircle.1(this));
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity] */
    public final void importBatchConfig(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "subid");
        if (AngConfigManager.INSTANCE.importBatchConfig(str, str2) > 0) {
            Toast makeText = Toast.makeText((Context) this, 2131755204, (int) REQUEST_CODE_VPN_PREPARE);
            makeText.show();
            Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
            getAdapter().updateConfigList();
            return;
        }
        Toast makeText2 = Toast.makeText((Context) this, 2131755192, (int) REQUEST_CODE_VPN_PREPARE);
        makeText2.show();
        Intrinsics.checkExpressionValueIsNotNull(makeText2, "Toast\n        .makeText(…         show()\n        }");
    }

    public final boolean importClipboard() {
        try {
            importBatchConfig$default(this, Utils.INSTANCE.getClipboard((Context) this), null, REQUEST_FILE_CHOOSER, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity] */
    public final boolean importConfigCustomClipboard() {
        try {
            String clipboard = Utils.INSTANCE.getClipboard(this);
            if (TextUtils.isEmpty(clipboard)) {
                Toast makeText = Toast.makeText((Context) this, 2131755197, (int) REQUEST_CODE_VPN_PREPARE);
                makeText.show();
                Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
                return false;
            }
            importCustomizeConfig(clipboard);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean importConfigCustomLocal() {
        try {
            showFileChooser();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity, java.lang.Object] */
    public final boolean importConfigCustomUrl(String str) {
        try {
            if (!Utils.INSTANCE.isValidUrl(str)) {
                Toast makeText = Toast.makeText((Context) this, 2131755194, (int) REQUEST_CODE_VPN_PREPARE);
                makeText.show();
                Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
                return false;
            }
            AsyncKt.doAsync$default((Object) this, (Function1) null, new importConfigCustomUrl.1((MainActivity) this, str), (int) REQUEST_SCAN, (Object) null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity] */
    public final boolean importConfigCustomUrlClipboard() {
        try {
            String clipboard = Utils.INSTANCE.getClipboard(this);
            if (!TextUtils.isEmpty(clipboard)) {
                return importConfigCustomUrl(clipboard);
            }
            Toast makeText = Toast.makeText((Context) this, 2131755197, (int) REQUEST_CODE_VPN_PREPARE);
            makeText.show();
            Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity, java.lang.Object] */
    public final boolean importConfigViaSub() {
        try {
            Toast makeText = Toast.makeText((Context) this, 2131755189, (int) REQUEST_CODE_VPN_PREPARE);
            makeText.show();
            Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
            ArrayList subItem = AngConfigManager.INSTANCE.getConfigs().getSubItem();
            int size = subItem.size();
            for (int i = REQUEST_CODE_VPN_PREPARE; i < size; i += REQUEST_SCAN) {
                if (!TextUtils.isEmpty(((AngConfig.SubItemBean) subItem.get(i)).getId()) && !TextUtils.isEmpty(((AngConfig.SubItemBean) subItem.get(i)).getRemarks())) {
                    if (!TextUtils.isEmpty(((AngConfig.SubItemBean) subItem.get(i)).getUrl())) {
                        String id = ((AngConfig.SubItemBean) subItem.get(i)).getId();
                        String url = ((AngConfig.SubItemBean) subItem.get(i)).getUrl();
                        if (Utils.INSTANCE.isValidUrl(url)) {
                            Log.d("Main", url);
                            AsyncKt.doAsync$default((Object) this, (Function1) null, new importConfigViaSub.1((MainActivity) this, url, id), (int) REQUEST_SCAN, (Object) null);
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity] */
    public final void importCustomizeConfig(String str) {
        if (str != null) {
            if (!V2rayConfigUtil.INSTANCE.isValidConfig(str)) {
                Toast makeText = Toast.makeText((Context) this, 2131755190, (int) REQUEST_CODE_VPN_PREPARE);
                makeText.show();
                Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
                return;
            }
            int importCustomizeConfig = AngConfigManager.INSTANCE.importCustomizeConfig(str);
            if (importCustomizeConfig > 0) {
                Toast makeText2 = Toast.makeText((Context) this, importCustomizeConfig, (int) REQUEST_CODE_VPN_PREPARE);
                makeText2.show();
                Intrinsics.checkExpressionValueIsNotNull(makeText2, "Toast\n        .makeText(…         show()\n        }");
                return;
            }
            Toast makeText3 = Toast.makeText((Context) this, 2131755204, (int) REQUEST_CODE_VPN_PREPARE);
            makeText3.show();
            Intrinsics.checkExpressionValueIsNotNull(makeText3, "Toast\n        .makeText(…         show()\n        }");
            getAdapter().updateConfigList();
        }
    }

    public final boolean importQRcode(int i) {
        RxPermissions rxPermissions = new RxPermissions((Activity) this);
        String[] strArr = new String[REQUEST_SCAN];
        strArr[REQUEST_CODE_VPN_PREPARE] = "android.permission.CAMERA";
        rxPermissions.request(strArr).subscribe(new importQRcode.1(this, i));
        return true;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        MainActivity.super.onActivityResult(i, i2, intent);
        if (i != 0) {
            String str = null;
            if (i != REQUEST_SCAN) {
                if (i != REQUEST_FILE_CHOOSER) {
                    if (i == REQUEST_SCAN_URL && i2 == -1) {
                        if (intent != null) {
                            str = intent.getStringExtra("SCAN_RESULT");
                        }
                        importConfigCustomUrl(str);
                    }
                } else if (i2 == -1) {
                    if (intent == null) {
                        Intrinsics.throwNpe();
                    }
                    Uri data = intent.getData();
                    Intrinsics.checkExpressionValueIsNotNull(data, "uri");
                    readContentFromUri(data);
                }
            } else if (i2 == -1) {
                importBatchConfig$default(this, intent != null ? intent.getStringExtra("SCAN_RESULT") : null, null, REQUEST_FILE_CHOOSER, null);
            }
        } else if (i2 == -1) {
            startV2Ray();
        }
    }

    public void onBackPressed() {
        if (_$_findCachedViewById(R.id.drawer_layout).isDrawerOpen(8388611)) {
            _$_findCachedViewById(R.id.drawer_layout).closeDrawer(8388611);
        } else {
            MainActivity.super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        MainActivity.super.onCreate(bundle);
        setContentView(2131492895);
        setTitle(getString(2131755186));
        setSupportActionBar(_$_findCachedViewById(R.id.toolbar));
        _$_findCachedViewById(R.id.fab).setOnClickListener(new onCreate.1(this));
        ((LinearLayout) _$_findCachedViewById(R.id.layout_test)).setOnClickListener(new onCreate.2(this));
        _$_findCachedViewById(R.id.recycler_view).setHasFixedSize(true);
        RecyclerView _$_findCachedViewById = _$_findCachedViewById(R.id.recycler_view);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "recycler_view");
        _$_findCachedViewById.setLayoutManager(new LinearLayoutManager((Context) this));
        RecyclerView _$_findCachedViewById2 = _$_findCachedViewById(R.id.recycler_view);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "recycler_view");
        _$_findCachedViewById2.setAdapter(getAdapter());
        this.mItemTouchHelper = new ItemTouchHelper(new SimpleItemTouchHelperCallback(getAdapter()));
        ItemTouchHelper itemTouchHelper = this.mItemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(_$_findCachedViewById(R.id.recycler_view));
        }
        DrawerLayout.DrawerListener actionBarDrawerToggle = new ActionBarDrawerToggle((Activity) this, _$_findCachedViewById(R.id.drawer_layout), _$_findCachedViewById(R.id.toolbar), 2131755100, 2131755099);
        _$_findCachedViewById(R.id.drawer_layout).addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        _$_findCachedViewById(R.id.nav_view).setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131558405, menu);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Intrinsics.checkParameterIsNotNull(keyEvent, "event");
        if (i != 4) {
            return MainActivity.super.onKeyDown(i, keyEvent);
        }
        moveTaskToBack(false);
        return true;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity] */
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 2131296329:
                AnkoInternals.internalStartActivity((Context) this, InappBuyActivity.class, new Pair[REQUEST_CODE_VPN_PREPARE]);
                break;
            case 2131296353:
                Utils.INSTANCE.openUri(this, "https://github.com/2dust/v2rayNG/issues");
                break;
            case 2131296409:
                AnkoInternals.internalStartActivity((Context) this, LogcatActivity.class, new Pair[REQUEST_CODE_VPN_PREPARE]);
                break;
            case 2131296441:
                Utils.INSTANCE.openUri(this, "https://1.2345345.xyz/ads.html");
                break;
            case 2131296480:
                Pair[] pairArr = new Pair[REQUEST_SCAN];
                pairArr[REQUEST_CODE_VPN_PREPARE] = TuplesKt.to("isRunning", Boolean.valueOf(this.isRunning));
                AnkoInternals.internalStartActivity((Context) this, SettingsActivity.class, pairArr);
                break;
            case 2131296506:
                AnkoInternals.internalStartActivity((Context) this, SubSettingActivity.class, new Pair[REQUEST_CODE_VPN_PREPARE]);
                break;
        }
        _$_findCachedViewById(R.id.drawer_layout).closeDrawer(8388611);
        return true;
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, com.d2rey.ang.ui.MainActivity, java.lang.Object, com.d2rey.ang.ui.BaseActivity] */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        int itemId = menuItem.getItemId();
        int i = REQUEST_CODE_VPN_PREPARE;
        switch (itemId) {
            case 2131296349:
                if (AngConfigManager.INSTANCE.shareAll2Clipboard() == 0) {
                    Toast makeText = Toast.makeText((Context) this, 2131755204, (int) REQUEST_CODE_VPN_PREPARE);
                    makeText.show();
                    Intrinsics.checkExpressionValueIsNotNull(makeText, "Toast\n        .makeText(…         show()\n        }");
                    return true;
                }
                Toast makeText2 = Toast.makeText((Context) this, 2131755192, (int) REQUEST_CODE_VPN_PREPARE);
                makeText2.show();
                Intrinsics.checkExpressionValueIsNotNull(makeText2, "Toast\n        .makeText(…         show()\n        }");
                return true;
            case 2131296384:
                importQRcode(REQUEST_SCAN);
                return true;
            case 2131296438:
                int size = AngConfigManager.INSTANCE.getConfigs().getVmess().size();
                for (int i2 = REQUEST_CODE_VPN_PREPARE; i2 < size; i2 += REQUEST_SCAN) {
                    ((AngConfig.VmessBean) AngConfigManager.INSTANCE.getConfigs().getVmess().get(i2)).setTestResult("");
                    getAdapter().updateConfigList();
                }
                Toast makeText3 = Toast.makeText((Context) this, 2131755063, (int) REQUEST_CODE_VPN_PREPARE);
                makeText3.show();
                Intrinsics.checkExpressionValueIsNotNull(makeText3, "Toast\n        .makeText(…         show()\n        }");
                int size2 = AngConfigManager.INSTANCE.getConfigs().getVmess().size();
                while (i < size2) {
                    if (((AngConfig.VmessBean) AngConfigManager.INSTANCE.getConfigs().getVmess().get(i)).getConfigType() != AppConfig.EConfigType.INSTANCE.getCustom()) {
                        AsyncKt.doAsync$default((Object) this, (Function1) null, new onOptionsItemSelected.1((MainActivity) this, i), (int) REQUEST_SCAN, (Object) null);
                    }
                    i += REQUEST_SCAN;
                }
                return true;
            case 2131296443:
                int size3 = AngConfigManager.INSTANCE.getConfigs().getVmess().size();
                for (int i3 = REQUEST_CODE_VPN_PREPARE; i3 < size3; i3 += REQUEST_SCAN) {
                    ((AngConfig.VmessBean) AngConfigManager.INSTANCE.getConfigs().getVmess().get(i3)).setTestResult("");
                    getAdapter().updateConfigList();
                }
                if (this.isRunning) {
                    Utils.INSTANCE.stopVService(this);
                }
                Toast makeText4 = Toast.makeText((Context) this, 2131755063, (int) REQUEST_CODE_VPN_PREPARE);
                makeText4.show();
                Intrinsics.checkExpressionValueIsNotNull(makeText4, "Toast\n        .makeText(…         show()\n        }");
                int size4 = AngConfigManager.INSTANCE.getConfigs().getVmess().size();
                while (i < size4) {
                    if (((AngConfig.VmessBean) AngConfigManager.INSTANCE.getConfigs().getVmess().get(i)).getConfigType() != AppConfig.EConfigType.INSTANCE.getCustom()) {
                        AsyncKt.doAsync$default((Object) this, (Function1) null, new onOptionsItemSelected.2((MainActivity) this, i), (int) REQUEST_SCAN, (Object) null);
                    }
                    i += REQUEST_SCAN;
                }
                return true;
            case 2131296507:
                importConfigViaSub();
                return true;
            default:
                switch (itemId) {
                    case 2131296375:
                        importClipboard();
                        return true;
                    case 2131296376:
                        importConfigCustomClipboard();
                        return true;
                    case 2131296377:
                        importConfigCustomLocal();
                        return true;
                    case 2131296378:
                        importConfigCustomUrlClipboard();
                        return true;
                    case 2131296379:
                        importQRcode(REQUEST_SCAN_URL);
                        return true;
                    case 2131296380:
                        Pair[] pairArr = new Pair[REQUEST_FILE_CHOOSER];
                        pairArr[REQUEST_CODE_VPN_PREPARE] = TuplesKt.to("position", -1);
                        pairArr[REQUEST_SCAN] = TuplesKt.to("isRunning", Boolean.valueOf(this.isRunning));
                        AnkoInternals.internalStartActivity((Context) this, Server4Activity.class, pairArr);
                        getAdapter().updateConfigList();
                        return true;
                    case 2131296381:
                        Pair[] pairArr2 = new Pair[REQUEST_FILE_CHOOSER];
                        pairArr2[REQUEST_CODE_VPN_PREPARE] = TuplesKt.to("position", -1);
                        pairArr2[REQUEST_SCAN] = TuplesKt.to("isRunning", Boolean.valueOf(this.isRunning));
                        AnkoInternals.internalStartActivity((Context) this, Server3Activity.class, pairArr2);
                        getAdapter().updateConfigList();
                        return true;
                    case 2131296382:
                        Pair[] pairArr3 = new Pair[REQUEST_FILE_CHOOSER];
                        pairArr3[REQUEST_CODE_VPN_PREPARE] = TuplesKt.to("position", -1);
                        pairArr3[REQUEST_SCAN] = TuplesKt.to("isRunning", Boolean.valueOf(this.isRunning));
                        AnkoInternals.internalStartActivity((Context) this, ServerActivity.class, pairArr3);
                        getAdapter().updateConfigList();
                        return true;
                    default:
                        return MainActivity.super.onOptionsItemSelected(menuItem);
                }
        }
    }

    public void onPause() {
        MainActivity.super.onPause();
    }

    public void onResume() {
        MainActivity.super.onResume();
        getAdapter().updateConfigList();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        MainActivity.super.onStart();
        setRunning(false);
        this.mMsgReceive = new ReceiveMessageHandler(this);
        registerReceiver(this.mMsgReceive, new IntentFilter("com.d2rey.ang.action.activity"));
        MessageUtil.INSTANCE.sendMsg2Service((Context) this, (int) REQUEST_SCAN, "");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        MainActivity.super.onStop();
        BroadcastReceiver broadcastReceiver = this.mMsgReceive;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.mMsgReceive = null;
        }
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
        getAdapter().setChangeable(!z);
        if (z) {
            FloatingActionButton _$_findCachedViewById = _$_findCachedViewById(R.id.fab);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "fab");
            _$_findCachedViewById.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor((Context) this, 2131099698)));
            String string = getString(2131755056);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.connection_connected)");
            setTestState(string);
        } else {
            FloatingActionButton _$_findCachedViewById2 = _$_findCachedViewById(R.id.fab);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "fab");
            _$_findCachedViewById2.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor((Context) this, 2131099699)));
            String string2 = getString(2131755057);
            Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.connection_not_connected)");
            setTestState(string2);
        }
        hideCircle();
    }

    public final void setTestState(String str) {
        Intrinsics.checkParameterIsNotNull(str, "content");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_test_state);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_test_state");
        textView.setText(str);
    }

    public final void showCircle() {
        FABProgressCircle _$_findCachedViewById = _$_findCachedViewById(R.id.fabProgressCircle);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.show();
        }
    }

    public final void startV2Ray() {
        if (AngConfigManager.INSTANCE.getConfigs().getIndex() >= 0) {
            showCircle();
            if (!Utils.INSTANCE.startVService((Context) this)) {
                hideCircle();
            }
        }
    }
}
