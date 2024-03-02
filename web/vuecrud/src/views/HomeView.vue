<template>
  <div>

    <el-card class="box-card">

      <el-input v-model="query.username" style="width: 200px" placeholder="请输入用户姓名" clearable></el-input>
      &nbsp;&nbsp;
      <el-button type="primary" @click="getUserList()">查询</el-button>
      <el-button type="primary" @click="handleCreate()">新增</el-button>

      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="id"></el-table-column>
        <el-table-column prop="username" label="姓名"></el-table-column>
        <el-table-column prop="gender" label="性别"></el-table-column>
        <el-table-column prop="age" label="年龄"></el-table-column>
        <el-table-column prop="idnumber" label="身份证号"></el-table-column>
        <el-table-column prop="phone" label="电话号"></el-table-column>
        <el-table-column prop="email" label="邮箱"></el-table-column>
        <el-table-column prop="joinDate" label="入职日期"></el-table-column>
        <el-table-column prop="avatar" label="头像"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.row)">编辑</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="this.query.page"
          :page-sizes="[5, 10, 20, 30]"
          :page-size="this.query.size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="this.total">
      </el-pagination>

    </el-card>

    <el-dialog title="新增员工" :visible.sync="dialogFormVisible1" width="40%" center>
      <el-form :model="form" :rules="rules" ref="formName">
        <el-form-item label="姓名" :label-width="formLabelWidth" prop="username">
          <el-input style="width: 90%" v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth" prop="gender">
          <el-select v-model="form.gender" placeholder="选择性别">
            <el-option label="女" value="女"></el-option>
            <el-option label="男" value="男"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth" prop="age">
          <el-input style="width: 90%" v-model="form.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="身份证号" :label-width="formLabelWidth" prop="IDNumber">
          <el-input style="width: 90%" v-model="form.IDNumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" :label-width="formLabelWidth" prop="phone">
          <el-input style="width: 90%" v-model="form.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" :label-width="formLabelWidth" prop="email">
          <el-input style="width: 90%" v-model="form.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="入职日期" :label-width="formLabelWidth" prop="joinDate">
          <el-input style="width: 90%" v-model="form.joinDate" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="头像" :label-width="formLabelWidth" prop="avatar">
          <el-input style="width: 90%" v-model="form.avatar" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
        <el-input style="width: 90%" v-model="form.password" autocomplete="off"></el-input>
      </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm()">确 定</el-button>
      </div>
    </el-dialog>

    <el-dialog title="修改信息" :visible.sync="dialogFormVisible" width="40%" center>
      <el-form :model="form" :rules="rules" ref="formName">
        <el-form-item label="姓名" :label-width="formLabelWidth" prop="username">
          <el-input style="width: 90%" v-model="form.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth" prop="gender">
          <el-select v-model="form.gender" placeholder="选择性别">
            <el-option label="女" value="女"></el-option>
            <el-option label="男" value="男"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth" prop="age">
          <el-input style="width: 90%" v-model="form.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="身份证号" :label-width="formLabelWidth" prop="IDNumber">
          <el-input style="width: 90%" v-model="form.IDNumber" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" :label-width="formLabelWidth" prop="phone">
          <el-input style="width: 90%" v-model="form.phone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" :label-width="formLabelWidth" prop="email">
          <el-input style="width: 90%" v-model="form.email" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="入职日期" :label-width="formLabelWidth" prop="joinDate">
          <el-input style="width: 90%" v-model="form.joinDate" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="头像" :label-width="formLabelWidth" prop="avatar">
          <el-input style="width: 90%" v-model="form.avatar" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth" prop="password">
          <el-input style="width: 90%" v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm()">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>

export default {
  name: 'HomeView',
  data(){
    return {
      query: {
        page: 1,
        size: 5,
        username: "",
      },
      total:0,
      currentPage: 1,
      tableData: [],
      form:{
        username:"",
        gender:"",
        age:"",
        IDNumber:"",
        phone:"",
        email:"",
        department:"",
        joinDate:"",
        avatar:"",
        password:""
      },
      formLabelWidth: '80px',
      dialogFormVisible: false,
      dialogFormVisible1: false,
      rules: {
        username: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 2, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
        gender: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        phone: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { pattern: /^1[3456789]\d{9}$/, message: '请输入正确格式的手机号', trigger: 'blur' }
        ],
        avatar: [
          { required: true, message: '请上传头像', trigger: 'change' },
        ],
      }
    }
  },
  methods: {
    //点击新增弹出弹窗
    handleCreate() {
      this.form={};
      this.dialogFormVisible = true;
    },
    //提交
    submitForm(){
      this.$refs.formName.validate((valid) => {
        //校验成功，提交数据到后端
        if(valid){
          this.axios.post("http://localhost:9090/user/saveOrUpdate",this.form).then((resp) => {
            let data = resp.data;
            console.log(resp)
            if(data.success){
              this.dialogFormVisible = false;
              this.dialogFormVisible1 = false;
              this.form = {};
              //重置表单校验状态
              this.$refs.formName.resetFields();
              this.getUserList();
              this.$message({
                message: '操作成功！',
                type: 'success'
              });
            }
          })
        }else {
          console.log('提交失败!');
          return false;
        }
    })
    },
    handleEdit(row) {
      console.log(row);
      this.form = row;
      this.dialogFormVisible = true;
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.query.size = val;
      this.getUserList();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.query.page = val;
      this.getUserList();
    },
    getUserList() {
      this.axios.get("http://localhost:9090/user/getList",{
        params:{
          username: this.query.username,
          page:this.query.page,
          size:this.query.size
        }
      }).then((resp) => {
        console.log(resp)
        this.tableData = resp.data.content.list;
        this.total = resp.data.content.total
      })
    }
  },
  //页面渲染时加载数据
  created() {
    this.getUserList();
  }
}
</script>
