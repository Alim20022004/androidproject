package com.example.myapplication;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class NetworkUtils {
    static String url = "http://192.168.137.65/signup.php";
    static String url1 = "http://192.168.137.65/login.php";
    public static void signUp(Context context, String username, String email, String password) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            Toast.makeText(context, "Sign Up Success", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(context, "Sign Up failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                , new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        Volley.newRequestQueue(context).add(stringRequest);
    }
    public static void validateCredentials(Context context, String email, String password, final VolleyCallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url1,
                new Response.Listener<String>() {
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        callback.onFailure(error.getMessage());
                    }
                }) {

            protected Map<String, String> getParams() throws AuthFailureError {
                // Set POST parameters
                Map params = new HashMap();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };
        Volley.newRequestQueue(context).add(stringRequest);
    }

    public interface VolleyCallback {
        void onSuccess(String result);
        void onFailure(String error);
    }
}




