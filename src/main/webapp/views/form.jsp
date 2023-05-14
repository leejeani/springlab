<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>


    $(function(){

    });
</script>
<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6  text-left ">
                <h1>Form</h1>
                <h2>${result}</h2>
                <form action="/formimpl" method="post" id="form_form" class="form-horizontal well">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="id">Image:</label>
                        <div class="col-sm-10">
                            <input type="text" name="id" class="form-control" id="id" value="{logincust.id}">
                        </div>
                    </div>
                    <div>
                        <input type="hidden" name="list[0]" value="">
                        <input type="hidden" name="" value="">
                        <input type="hidden" name="" value="">
                        <input type="hidden" name="" value="">
                        <input type="hidden" name="" value="">
                        <input type="hidden" name="" value="">

                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="cfr1_btn" type="submit" class="btn btn-default">Send</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>