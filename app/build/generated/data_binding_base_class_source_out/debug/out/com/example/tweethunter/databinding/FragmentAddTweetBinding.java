// Generated by view binder compiler. Do not edit!
package com.example.tweethunter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tweethunter.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddTweetBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView profilePic;

  @NonNull
  public final Button submitButton;

  @NonNull
  public final EditText textEditText;

  private FragmentAddTweetBinding(@NonNull FrameLayout rootView, @NonNull ImageView profilePic,
      @NonNull Button submitButton, @NonNull EditText textEditText) {
    this.rootView = rootView;
    this.profilePic = profilePic;
    this.submitButton = submitButton;
    this.textEditText = textEditText;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddTweetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddTweetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add_tweet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddTweetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.profile_pic;
      ImageView profilePic = ViewBindings.findChildViewById(rootView, id);
      if (profilePic == null) {
        break missingId;
      }

      id = R.id.submit_button;
      Button submitButton = ViewBindings.findChildViewById(rootView, id);
      if (submitButton == null) {
        break missingId;
      }

      id = R.id.text_edit_text;
      EditText textEditText = ViewBindings.findChildViewById(rootView, id);
      if (textEditText == null) {
        break missingId;
      }

      return new FragmentAddTweetBinding((FrameLayout) rootView, profilePic, submitButton,
          textEditText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
