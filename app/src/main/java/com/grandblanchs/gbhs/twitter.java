package com.grandblanchs.gbhs;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link twitter.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link twitter#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class twitter extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //This is authentication for the first step of logging into Twitter
    private final static String CONSUMER_KEY = "0S62lfz7hGX39oZo2jJmrhZ96";
    private final static String CONSUMER_KEY_SECRET ="Pr1YnBtFU5OErrxhpLNet2S6KolhRm43cfwZuFPCQLOasEPXm7";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment twitter.
     */
    // TODO: Rename and change types and number of parameters
    public static twitter newInstance(String param1, String param2) {
        twitter fragment = new twitter();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public twitter() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.twitter, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btn_tweet = (Button) getView().findViewById(R.id.btn_tweet);
        btn_tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new twitterPost().execute();
            }

        });
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) throws TwitterException, IOException{
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    private class twitterPost extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

            String accessToken = "2832408273-pvUljzIaVPHm9SgWAqwQXXbBQgA9AYQ8gKI9XEQ";
            String accessTokenSecret = "0NI1CVcbKCZDWjIqqipN7LZuWuCDAqVaL37Wf6XgAa9Ww";

            AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
            twitter.setOAuthAccessToken(oathAccessToken);

            try {
                twitter.updateStatus("Hi, this was updated using android studio.");
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            System.out.println("\nMy Timeline:");
            return null;
        }
    }

}
