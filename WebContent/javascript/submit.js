hide_review_panels = function() {
	$('#knowledge_div').hide();
	$('#quiz_div').hide();
	$('#summary_div').hide();
	$('#history_div').hide();
	$('#knowledgeadd_div').hide();
	$('#knowledgeaddsc_div').hide();
};

hide_code_panels = function() {
	$('#codelist_div').hide();
	$('#codedetails_div').hide();
	$('#codecomment_div').hide();
	$('#codecommenthis_div').hide();
	$('#codedetailadd_div').hide();
	$('#codeaddsuccess_div').hide();
};

hide_exam_panels = function() {
	$('#examadd_div').hide();
	$('#examaddsc_div').hide();
	$('#examtry_div').hide();
	$('#examtryend_div').hide();
	$('#examsummary_div').hide();
};


show_knowledge = function(page){
	//alert(page);
	hide_review_panels();
	$.ajax({
        url: 'knowledge.action',
        type: 'POST',
        dataType: 'html',
        data :{category:$("#knowledge_category").val(),
        	page: page},
        timeout: 20000,
        error: function(){
            alert('Timeout when loading knowledge page');
        },
        success: function(data){
            $('#knowledge_div').show();
			$('#knowledge_div').html(data);	       
        }
    }); 
};

show_add_knowledge_page = function(){
	//alert(page);
	hide_review_panels();
	$.ajax({
        url: 'addknowledge.action',
        type: 'POST',
        dataType: 'html',
        timeout: 20000,
        error: function(){
            alert('Timeout when loading add knowledge page');
        },
        success: function(data){
            $('#knowledgeadd_div').show();
			$('#knowledgeadd_div').html(data);	       
        }
    }); 
};

show_quiz = function() {
	hide_review_panels();
	$.ajax({
        url: 'quiz.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	category:$("#knowledge_category").val()
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading knowledge page');
        },
        success: function(data){
            $('#quiz_div').show();
			$('#quiz_div').html(data);	       
        }
    });
};

show_answer = function() {
	$('#answer_sec_div').show();
};

add_quiz = function() {
	hide_review_panels();
	$.ajax({
        url: 'addQuiz.action',
        type: 'POST',
        dataType: 'html',
        data :{q_id:$("#addQuiz_id").val(),
        	ans: $("#addQuiz_ans").val(),
        	comment: $("#addQuiz_comment").val(),
        	answer: $("#addQuiz_answer").val(),
        	question: $("#addQuiz_question").val()},
        timeout: 20000,
        error: function(){
            alert('Timeout when loading quiz page');
        },
        success: function(data){
            $('#summary_div').show();
			$('#summary_div').html(data);	       
        }
    }); 
};

show_quiz_history = function(page) {
	hide_review_panels();
	//alert(page);
	$.ajax({
        url: 'quizhistory.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	category:$("#knowledge_category").val(),
        	page: page
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading quiz history page');
        },
        success: function(data){
            $('#history_div').show();
			$('#history_div').html(data);	       
        }
    }); 
};

show_all_coding_questions = function () {
	hide_code_panels();
	$.ajax({
        url: 'allcode.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	category:$("#allcode_category").val()
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading all code page');
        },
        success: function(data){
            $('#codelist_div').show();
			$('#codelist_div').html(data);	       
        }
    }); 
};

show_code_details = function (cId) {
	hide_code_panels();
	$.ajax({
        url: 'codedetails.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	codingId:cId
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading code details page');
        },
        success: function(data){
            $('#codedetails_div').show();
			$('#codedetails_div').html(data);	       
        }
    }); 
	
	$.ajax({
        url: 'codecomment.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	codingId:cId
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading code comment page');
        },
        success: function(data){
            $('#codecomment_div').show();
			$('#codecomment_div').html(data);	       
        }
    }); 
};

add_code_comment = function() {
	$('#codecomment_div').hide();
	$.ajax({
        url: 'addcodecomment.action',
        type: 'POST',
        dataType: 'html',
        data :{codingId:$("#addcodecomment_codingId").val(),
        	ccomment: $("#addcodecomment_ccomment").val()},
        timeout: 20000,
        error: function(){
            alert('Timeout when loading code comment page');
        },
        success: function(data){
            $('#codecomment_div').show();
			$('#codecomment_div').html(data);	       
        }
    }); 
};

show_comment_history = function (page) {
	hide_code_panels();
	$.ajax({
        url: 'codecommenthistory.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	category:$("#allcode_category").val(),
        	page:page
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading code comment history page');
        },
        success: function(data){
            $('#codecommenthis_div').show();
			$('#codecommenthis_div').html(data);	       
        }
    }); 
};

show_add_code_page = function () {
	hide_code_panels();
	$.ajax({
        url: 'codedetailadd.action',
        type: 'POST',
        dataType: 'html',
        timeout: 20000,
        error: function(){
            alert('Timeout when loading add code detail page');
        },
        success: function(data){
            $('#codedetailadd_div').show();
			$('#codedetailadd_div').html(data);	       
        }
    }); 
};

show_add_exam_page = function () {
	hide_exam_panels();
	$.ajax({
        url: 'examadd.action',
        type: 'POST',
        dataType: 'html',
        timeout: 20000,
        error: function(){
            alert('Timeout when loading add exam page');
        },
        success: function(data){
            $('#examadd_div').show();
			$('#examadd_div').html(data);	       
        }
    }); 
};

show_exam_question = function (examId) {
	hide_exam_panels();
	$.ajax({
        url: 'examtry.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	examId:examId
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading try exam page');
        },
        success: function(data){
            $('#examtry_div').show();
			$('#examtry_div').html(data);	       
        },
        end: function(data) {
        	$('#examtryend_div').show();
			$('#examtryend_div').html(data);
        }
    }); 
	
};

show_exam_answer = function() {
	$('#examanser_div').show();
};

add_exam_try = function (examId) {
	//hide_exam_panels();
	$.ajax({
        url: 'addexamtry.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	examId:examId,
        	yanswer:$("#addexamtry_yanswer").val(),
        	comment:$("#addexamtry_comment").val()
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when saving exam try');
        },
        success: function(data){
            //alert('sucessfully save exam try');	       
        }
    }); 
	hide_exam_panels();
	$.ajax({
        url: 'examtry.action',
        type: 'POST',
        dataType: 'html',
        data :{
        	examId:examId
        },
        timeout: 20000,
        error: function(){
            alert('Timeout when loading try exam page');
        },
        success: function(data){
            $('#examtry_div').show();
			$('#examtry_div').html(data);	       
        }
    }); 
};

show_exam_try_summary = function(page){
	hide_exam_panels();
	$.ajax({
        url: 'examtrysummary.action',
        type: 'POST',
        dataType: 'html',
        data :{page: page},
        timeout: 20000,
        error: function(){
            alert('Timeout when loading exam try summary page');
        },
        success: function(data){
            $('#examsummary_div').show();
			$('#examsummary_div').html(data);	       
        }
    }); 
};
