package org.cli.collect.android.injection.config;

import android.app.Application;
import android.telephony.SmsManager;

import org.javarosa.core.reference.ReferenceManager;
import org.cli.collect.android.activities.FormDownloadList;
import org.cli.collect.android.activities.FormEntryActivity;
import org.cli.collect.android.activities.FormMapActivity;
import org.cli.collect.android.activities.GeoPointMapActivity;
import org.cli.collect.android.activities.GeoPolyActivity;
import org.cli.collect.android.activities.GoogleDriveActivity;
import org.cli.collect.android.activities.GoogleSheetsUploaderActivity;
import org.cli.collect.android.activities.InstanceUploaderListActivity;
import org.cli.collect.android.activities.MainMenuActivity;
import org.cli.collect.android.adapters.InstanceUploaderAdapter;
import org.cli.collect.android.analytics.Analytics;
import org.cli.collect.android.application.Collect;
import org.cli.collect.android.events.RxEventBus;
import org.cli.collect.android.formentry.ODKView;
import org.cli.collect.android.fragments.DataManagerList;
import org.cli.collect.android.geo.GoogleMapFragment;
import org.cli.collect.android.geo.MapboxMapFragment;
import org.cli.collect.android.geo.OsmDroidMapFragment;
import org.cli.collect.android.fragments.ShowQRCodeFragment;
import org.cli.collect.android.logic.PropertyManager;
import org.cli.collect.android.openrosa.OpenRosaHttpInterface;
import org.cli.collect.android.preferences.AdminSharedPreferences;
import org.cli.collect.android.preferences.FormMetadataFragment;
import org.cli.collect.android.preferences.GeneralSharedPreferences;
import org.cli.collect.android.preferences.ServerPreferencesFragment;
import org.cli.collect.android.storage.migration.StorageMigrationDialog;
import org.cli.collect.android.storage.migration.StorageMigrationService;
import org.cli.collect.android.tasks.InstanceServerUploaderTask;
import org.cli.collect.android.tasks.ServerPollingJob;
import org.cli.collect.android.tasks.sms.SmsNotificationReceiver;
import org.cli.collect.android.tasks.sms.SmsSender;
import org.cli.collect.android.tasks.sms.SmsSentBroadcastReceiver;
import org.cli.collect.android.tasks.sms.SmsService;
import org.cli.collect.android.tasks.sms.contracts.SmsSubmissionManagerContract;
import org.cli.collect.android.upload.AutoSendWorker;
import org.cli.collect.android.utilities.AuthDialogUtility;
import org.cli.collect.android.utilities.FormDownloader;
import org.cli.collect.android.widgets.ExStringWidget;
import org.cli.collect.android.widgets.QuestionWidget;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Dagger component for the application. Should include
 * application level Dagger Modules and be built with Application
 * object.
 *
 * Add an `inject(MyClass myClass)` method here for objects you want
 * to inject into so Dagger knows to wire it up.
 *
 * Annotated with @Singleton so modules can include @Singletons that will
 * be retained at an application level (as this an instance of this components
 * is owned by the Application object).
 *
 * If you need to call a provider directly from the component (in a test
 * for example) you can add a method with the type you are looking to fetch
 * (`MyType myType()`) to this interface.
 *
 * To read more about Dagger visit: https://google.github.io/dagger/users-guide
 **/

@Singleton
@Component(modules = {
        AppDependencyModule.class
})
public interface AppDependencyComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        Builder appDependencyModule(AppDependencyModule testDependencyModule);

        AppDependencyComponent build();
    }

    void inject(Collect collect);

    void inject(SmsService smsService);

    void inject(SmsSender smsSender);

    void inject(SmsSentBroadcastReceiver smsSentBroadcastReceiver);

    void inject(SmsNotificationReceiver smsNotificationReceiver);

    void inject(InstanceUploaderAdapter instanceUploaderAdapter);

    void inject(DataManagerList dataManagerList);

    void inject(PropertyManager propertyManager);

    void inject(FormEntryActivity formEntryActivity);

    void inject(InstanceServerUploaderTask uploader);

    void inject(ServerPreferencesFragment serverPreferencesFragment);

    void inject(FormDownloader formDownloader);

    void inject(ServerPollingJob serverPollingJob);

    void inject(AuthDialogUtility authDialogUtility);

    void inject(FormDownloadList formDownloadList);

    void inject(InstanceUploaderListActivity activity);

    void inject(GoogleDriveActivity googleDriveActivity);

    void inject(GoogleSheetsUploaderActivity googleSheetsUploaderActivity);

    void inject(QuestionWidget questionWidget);

    void inject(ExStringWidget exStringWidget);

    void inject(ODKView odkView);

    void inject(FormMetadataFragment formMetadataFragment);

    void inject(GeoPointMapActivity geoMapActivity);

    void inject(GeoPolyActivity geoPolyActivity);

    void inject(FormMapActivity formMapActivity);

    void inject(OsmDroidMapFragment mapFragment);

    void inject(GoogleMapFragment mapFragment);

    void inject(MapboxMapFragment mapFragment);

    void inject(MainMenuActivity mainMenuActivity);

    void inject(ShowQRCodeFragment showQRCodeFragment);

    void inject(StorageMigrationService storageMigrationService);

    void inject(AutoSendWorker autoSendWorker);

    void inject(StorageMigrationDialog storageMigrationDialog);

    SmsManager smsManager();

    SmsSubmissionManagerContract smsSubmissionManagerContract();

    RxEventBus rxEventBus();

    OpenRosaHttpInterface openRosaHttpInterface();

    ReferenceManager referenceManager();

    Analytics analytics();

    GeneralSharedPreferences generalSharedPreferences();

    AdminSharedPreferences adminSharedPreferences();
}
