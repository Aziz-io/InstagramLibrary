package com.example.insta_test.actions;

import com.example.insta_test.IGClient;
import com.example.insta_test.actions.account.AccountAction;
import com.example.insta_test.actions.igtv.IgtvAction;
import com.example.insta_test.actions.search.SearchAction;
import com.example.insta_test.actions.simulate.SimulateAction;
import com.example.insta_test.actions.status.StatusAction;
import com.example.insta_test.actions.story.StoryAction;
import com.example.insta_test.actions.timeline.TimelineAction;
import com.example.insta_test.actions.upload.UploadAction;
import com.example.insta_test.actions.users.UsersAction;

import java.lang.reflect.Field;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;

@Accessors(fluent = true, prefix = "_")
@Getter
public class IGClientActions {
    private UploadAction _upload;
    private TimelineAction _timeline;
    private StoryAction _story;
    private UsersAction _users;
    private SimulateAction _simulate;
    private IgtvAction _igtv;
    private AccountAction _account;
    private SearchAction _search;
    private StatusAction _status;

    public TimelineAction get_timeline() {
        return _timeline;
    }

    @SneakyThrows
    public IGClientActions(IGClient client) {
        for (Field field : this.getClass().getDeclaredFields())
            if (field.getName().startsWith("_"))
                field.set(this, field.getType().getConstructor(IGClient.class).newInstance(client));
    }

}
