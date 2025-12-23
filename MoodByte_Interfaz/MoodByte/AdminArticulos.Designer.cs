namespace MoodByte
{
    partial class AdminArticulos
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            btnNuevoArticulo = new Button();
            btnEditarArticulo = new Button();
            btnBorrarArticulo = new Button();
            imageList1 = new ImageList(components);
            listViewArticulos = new ListView();
            pictureBoxArticulo = new PictureBox();
            panelTituloArticulo = new Panel();
            lblTitulo = new Label();
            navMenu = new Controles.Menu();
            ((System.ComponentModel.ISupportInitialize)pictureBoxArticulo).BeginInit();
            panelTituloArticulo.SuspendLayout();
            SuspendLayout();
            // 
            // btnNuevoArticulo
            // 
            btnNuevoArticulo.Location = new Point(75, 527);
            btnNuevoArticulo.Margin = new Padding(3, 4, 3, 4);
            btnNuevoArticulo.Name = "btnNuevoArticulo";
            btnNuevoArticulo.Size = new Size(86, 31);
            btnNuevoArticulo.TabIndex = 1;
            btnNuevoArticulo.Text = "Nuevo";
            btnNuevoArticulo.UseVisualStyleBackColor = true;
            btnNuevoArticulo.Click += btnNuevoArticulo_Click;
            // 
            // btnEditarArticulo
            // 
            btnEditarArticulo.Location = new Point(168, 527);
            btnEditarArticulo.Margin = new Padding(3, 4, 3, 4);
            btnEditarArticulo.Name = "btnEditarArticulo";
            btnEditarArticulo.Size = new Size(86, 31);
            btnEditarArticulo.TabIndex = 2;
            btnEditarArticulo.Text = "Editar";
            btnEditarArticulo.UseVisualStyleBackColor = true;
            btnEditarArticulo.Click += btnEditarArticulo_Click;
            // 
            // btnBorrarArticulo
            // 
            btnBorrarArticulo.Location = new Point(274, 527);
            btnBorrarArticulo.Margin = new Padding(3, 4, 3, 4);
            btnBorrarArticulo.Name = "btnBorrarArticulo";
            btnBorrarArticulo.Size = new Size(86, 31);
            btnBorrarArticulo.TabIndex = 3;
            btnBorrarArticulo.Text = "Borrar";
            btnBorrarArticulo.UseVisualStyleBackColor = true;
            btnBorrarArticulo.Click += btnBorrarArticulo_Click;
            // 
            // imageList1
            // 
            imageList1.ColorDepth = ColorDepth.Depth32Bit;
            imageList1.ImageSize = new Size(16, 16);
            imageList1.TransparentColor = Color.Transparent;
            // 
            // listViewArticulos
            // 
            listViewArticulos.FullRowSelect = true;
            listViewArticulos.Location = new Point(488, 56);
            listViewArticulos.Margin = new Padding(3, 4, 3, 4);
            listViewArticulos.Name = "listViewArticulos";
            listViewArticulos.Size = new Size(333, 500);
            listViewArticulos.TabIndex = 4;
            listViewArticulos.UseCompatibleStateImageBehavior = false;
            listViewArticulos.View = View.List;
            listViewArticulos.SelectedIndexChanged += listViewArticulos_SelectedIndexChanged;
            // 
            // pictureBoxArticulo
            // 
            pictureBoxArticulo.Location = new Point(75, 56);
            pictureBoxArticulo.Margin = new Padding(3, 4, 3, 4);
            pictureBoxArticulo.Name = "pictureBoxArticulo";
            pictureBoxArticulo.Size = new Size(285, 247);
            pictureBoxArticulo.TabIndex = 5;
            pictureBoxArticulo.TabStop = false;
            // 
            // panelTituloArticulo
            // 
            panelTituloArticulo.Controls.Add(lblTitulo);
            panelTituloArticulo.Location = new Point(75, 343);
            panelTituloArticulo.Margin = new Padding(3, 4, 3, 4);
            panelTituloArticulo.Name = "panelTituloArticulo";
            panelTituloArticulo.Size = new Size(285, 79);
            panelTituloArticulo.TabIndex = 6;
            // 
            // lblTitulo
            // 
            lblTitulo.AutoSize = true;
            lblTitulo.Location = new Point(16, 32);
            lblTitulo.Name = "lblTitulo";
            lblTitulo.Size = new Size(42, 20);
            lblTitulo.TabIndex = 0;
            lblTitulo.Text = "TEXT";
            // 
            // navMenu
            // 
            navMenu.BackColor = Color.Transparent;
            navMenu.ForeColor = SystemColors.ControlText;
            navMenu.Location = new Point(8, 4);
            navMenu.Margin = new Padding(3, 5, 3, 5);
            navMenu.Name = "navMenu";
            navMenu.Size = new Size(246, 32);
            navMenu.TabIndex = 7;
            // 
            // AdminArticulos
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(914, 600);
            Controls.Add(navMenu);
            Controls.Add(panelTituloArticulo);
            Controls.Add(pictureBoxArticulo);
            Controls.Add(listViewArticulos);
            Controls.Add(btnBorrarArticulo);
            Controls.Add(btnEditarArticulo);
            Controls.Add(btnNuevoArticulo);
            Margin = new Padding(3, 4, 3, 4);
            Name = "AdminArticulos";
            Text = "AdminArticulos";
            Load += AdminArticulos_Load;
            ((System.ComponentModel.ISupportInitialize)pictureBoxArticulo).EndInit();
            panelTituloArticulo.ResumeLayout(false);
            panelTituloArticulo.PerformLayout();
            ResumeLayout(false);
        }

        #endregion
        private Button btnNuevoArticulo;
        private Button btnEditarArticulo;
        private Button btnBorrarArticulo;
        private ImageList imageList1;
        private ListView listViewArticulos;
        private PictureBox pictureBoxArticulo;
        private Panel panelTituloArticulo;
        private Label lblTitulo;
        private Controles.Menu navMenu;
    }
}